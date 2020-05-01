package com.foxhole.spacex.ui.rocketDetails

import android.content.Context
import android.os.Bundle
import android.view.View
import com.foxhole.spacex.BaseApplication
import com.foxhole.spacex.R
import com.foxhole.spacex.base.BaseFragment
import com.foxhole.spacex.databinding.FragmentDetailsRocketBinding

class RocketDetailsFragment : BaseFragment<FragmentDetailsRocketBinding, RocketDetailsViewModel>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val rocketID = RocketDetailsFragmentArgs.fromBundle(it)
            println("rocket_debug : ${rocketID.rocketID}")
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().applicationContext as BaseApplication).appComponent.newRocketDetailsSubComponent().inject(this)
    }

    override fun getLayoutId(): Int = R.layout.fragment_details_rocket

    override fun getViewModel(): Class<RocketDetailsViewModel> = RocketDetailsViewModel::class.java

}
