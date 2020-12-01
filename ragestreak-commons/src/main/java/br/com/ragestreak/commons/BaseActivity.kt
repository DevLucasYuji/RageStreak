package br.com.ragestreak.commons

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.play.core.splitcompat.SplitCompat
import com.google.android.play.core.splitinstall.SplitInstallManager
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus.*

abstract class BaseActivity : AppCompatActivity() {

    companion object {
        private const val BASE_ACTIVITY_TAG = "BASE_ACTIVITY_TAG"
    }

    abstract val layoutRes: Int

    lateinit var manager: SplitInstallManager
        private set

    private var featureDownloadListener: (() -> Unit)? = null
    private var featureInstalledListener: (() -> Unit)? = null
    private var featureInstallingListener: (() -> Unit)? = null
    private var featureFailedListener: (() -> Unit)? = null
    private var featureRequiresUserConfirmation: (() -> Unit)? = null

    private val listener = SplitInstallStateUpdatedListener { state ->
        when (state.status()) {
            DOWNLOADING -> featureDownloadListener?.invoke()
            REQUIRES_USER_CONFIRMATION -> featureRequiresUserConfirmation?.invoke()
            INSTALLED -> featureInstalledListener?.invoke()
            INSTALLING -> featureInstallingListener?.invoke()
            FAILED -> featureFailedListener?.invoke()
            else -> Log.e(BASE_ACTIVITY_TAG, "Unknown Status from dynamic feature")
        }
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
        SplitCompat.installActivity(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes)
        manager = SplitInstallManagerFactory.create(this)
    }

    override fun onResume() {
        manager.registerListener(listener)
        super.onResume()
    }

    override fun onPause() {
        manager.unregisterListener(listener)
        super.onPause()
    }

    private fun createIntent(activityName: String, callback: ((bundle: Intent) -> Unit)) {
        val intent = Intent()
        intent.setClassName(packageName, activityName)
        callback.invoke(intent)
    }

    fun getDeliveryIntent(
        moduleName: String,
        activityName: String,
        isIncluded: Boolean = false,
        callback: ((bundle: Intent) -> Unit)
    ) {
        Log.d(BASE_ACTIVITY_TAG, "loading $moduleName")
        if (manager.installedModules.contains(moduleName)) {
            createIntent(activityName, callback)
            return
        }

        if (isIncluded) {
            val request = SplitInstallRequest.newBuilder()
                .addModule(moduleName)
                .build()

            manager.startInstall(request).addOnSuccessListener {
                createIntent(activityName, callback)
            }

            Log.d(BASE_ACTIVITY_TAG, "Starting install for $moduleName")
        }
    }
}