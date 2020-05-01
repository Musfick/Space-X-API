package com.foxhole.spacex.ui.rockets

import android.content.Context
import android.os.Bundle
import android.view.View
import com.foxhole.spacex.BaseApplication
import com.foxhole.spacex.R
import com.foxhole.spacex.base.BaseFragment
import com.foxhole.spacex.databinding.FragmentRocketsBinding
import com.foxhole.spacex.ui.home.HomeViewModel


class RocketsFragment : BaseFragment<FragmentRocketsBinding, RocketsViewModel>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().applicationContext as BaseApplication).appComponent.newRocketsSubComponent().inject(this)
    }

    override fun getLayoutId(): Int = R.layout.fragment_rockets

    override fun getViewModel(): Class<RocketsViewModel> = RocketsViewModel::class.java
}
