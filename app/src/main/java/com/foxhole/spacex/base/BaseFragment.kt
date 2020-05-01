package com.foxhole.spacex.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.foxhole.spacex.factory.ViewModelFactory
import javax.inject.Inject

/**
 * Created by Musfick Jamil on 4/27/2020$.
 */

abstract class BaseFragment<T : ViewDataBinding, VM : ViewModel>() : Fragment(){

    protected lateinit var binding : T
    protected lateinit var viewModel : VM
    @Inject
    lateinit var factory : ViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        //init viewModel
        viewModel = ViewModelProvider(this, factory)[getViewModel()]
        return binding.root
    }

    abstract fun getLayoutId() : Int
    abstract fun getViewModel() : Class<VM>

}