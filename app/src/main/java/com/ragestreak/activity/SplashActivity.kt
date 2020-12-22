package com.ragestreak.activity

import android.content.Intent
import com.ragestreak.R
import com.ragestreak.commons.BaseActivity
import kotlinx.coroutines.*

class SplashActivity : BaseActivity() {

    companion object {
        private const val DELAY_TIME = 2000L
    }

    private var job: Job? = null

    override val layoutRes: Int
        get() = R.layout.activity_splash

    override fun initView() {
        job = splashDelay()
    }

    override fun onResume() {
        super.onResume()
        job = splashDelay()
    }

    override fun onPause() {
        job?.cancel()
        super.onPause()
    }

    private fun splashDelay(): Job {
        return CoroutineScope(Dispatchers.Main).launch {
            delay(DELAY_TIME)
            val intent = Intent(this@SplashActivity, NavigationActivity::class.java)
            startActivity(intent)
        }
    }
}