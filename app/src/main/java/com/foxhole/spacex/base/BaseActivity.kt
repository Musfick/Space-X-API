package com.foxhole.spacex.base

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.foxhole.spacex.factory.ViewModelFactory
import javax.inject.Inject

/**
 * Created by Musfick Jamil on 4/27/2020$.
 */

abstract class BaseActivity<T : ViewDataBinding, VM : ViewModel> : AppCompatActivity(){

    protected lateinit var binding : T
    protected lateinit var viewModel: VM

//    @Inject
//    lateinit var factory : ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        val view = binding.root
        setContentView(view)

        //inject activity
        onActivityInject()

        //init viewModel

        //ready view to use
        onViewReady(savedInstanceState)
    }


    @CallSuper
    protected open fun onViewReady(savedInstanceState: Bundle?) {
        // use this method in child activity
    }

    @CallSuper
    protected open fun onActivityInject() {
        // use this method in child activity for inject
    }



    abstract fun getLayoutId() : Int
    abstract fun getViewModel() : Class<VM>
}