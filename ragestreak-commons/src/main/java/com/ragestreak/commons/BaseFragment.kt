package com.ragestreak.commons

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.ragestreak.commons.modules.RequireInject
import com.ragestreak.commons.modules.StorageModule

abstract class BaseFragment<B : ViewDataBinding> : Fragment() {

    abstract val layoutRes: Int

    abstract fun afterViews()

    lateinit var binding: B

    var bottomNavigation: View? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (this is RequireInject) {
            val application = (activity?.application as? StorageModule)
            application?.addModules(getModules())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottomNavigation = (activity as? BaseActivity)?.bottomNavigationView
        afterViews()
    }


    private fun getAnimation(anim: Int, callback: (() -> Unit)? = null): Animation {
        val animation = AnimationUtils.loadAnimation(context, anim)
        animation.setAnimationListener(object: Animation.AnimationListener {
            override fun onAnimationRepeat(p0: Animation?) {}

            override fun onAnimationEnd(p0: Animation?) {
                callback?.invoke()
            }

            override fun onAnimationStart(p0: Animation?) {}
        })

        return animation
    }

    fun fadeInBottomNavigation() {
        visibleBottomNavigation()
        val animation = getAnimation(R.anim.fade_in)
        bottomNavigation?.startAnimation(animation)
    }

    fun fadeOutBottomNavigation() {
        val animation = getAnimation(R.anim.fade_out) {
            goneBottomNavigation()
        }
        bottomNavigation?.startAnimation(animation)
    }

    private fun visibleBottomNavigation() {
        bottomNavigation?.visibility = View.VISIBLE
    }

    private fun goneBottomNavigation() {
        bottomNavigation?.visibility = View.GONE
    }
}