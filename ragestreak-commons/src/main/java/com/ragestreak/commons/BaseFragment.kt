package com.ragestreak.commons

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ragestreak.commons.modules.RequireInject
import com.ragestreak.commons.modules.StorageModule
import org.koin.android.ext.android.get
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

abstract class BaseFragment<VM : BaseViewModel> : Fragment() {

    abstract val layoutRes: Int

    abstract fun afterViews()

    lateinit var viewModel: Class<VM>

    var bottomNavigation: View? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(this is RequireInject) {
            val application = (context as StorageModule)
            application.addModules(getModules())
        }
        viewModel = get()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(layoutRes, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        afterViews()
        bottomNavigation = (activity as? BaseActivity)?.bottomNavigationView
    }
}