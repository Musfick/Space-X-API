package com.foxhole.spacex.ui.rocketDetails

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import coil.api.load
import com.foxhole.spacex.BaseApplication
import com.foxhole.spacex.R
import com.foxhole.spacex.base.BaseFragment
import com.foxhole.spacex.databinding.FragmentDetailsRocketBinding
import com.foxhole.spacex.model.rocket.Rocket
import com.foxhole.spacex.utils.Resource
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar

class RocketDetailsFragment : BaseFragment<FragmentDetailsRocketBinding, RocketDetailsViewModel>(), View.OnClickListener {

    private lateinit var rocket: Rocket

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val args = RocketDetailsFragmentArgs.fromBundle(it)
            println("details_debug : ${args.rocketID}")
            viewModel.setRocketId(args.rocketID)
        }

        observeOneRocket()
        binding.saveBtn.setOnClickListener(this)
    }

    private fun observeOneRocket() {
        viewModel.oneRocket.observe(viewLifecycleOwner, Observer {
            it?.let {
                when(it.status){
                    Resource.Status.LOADING -> handleLoading()
                    Resource.Status.SUCCESS -> handleSuccess(it.data)
                    Resource.Status.ERROR -> handleError(it.message)
                    Resource.Status.REFRESHING -> handleRefreshing()
                    Resource.Status.REFRESHED -> handleRefreshed()
                }
            }
        })
    }

    private fun handleRefreshed() {
        println("details_debug : Refreshed...")
    }

    private fun handleRefreshing() {
        println("details_debug : Refreshing...")
    }

    private fun handleError(message: String?) {
        println("details_debug : Error...")
        binding.layoutLoading.visibility = View.GONE
        binding.layoutError.visibility = View.VISIBLE
    }

    private fun handleSuccess(data: Rocket?) {
        println("details_debug : success...")
        binding.layoutLoading.visibility = View.GONE
        binding.mainView.visibility = View.VISIBLE
        updateUI(data)
    }

    private fun updateUI(data: Rocket?) {
        data?.let {

            rocket = data
            binding.imageView.load(it.flickrImages[0])
            binding.name.text = it.rocketName
            binding.descript.text = it.description

            //Very bad practice
            binding.details.text = "Launch cost : ${it.costPerLaunch}\n"+
                    "Cost : ${it.costPerLaunch}$\n"+
                    "Weight : ${it.mass.kg/1000}Kg\n"+
                    "Height : ${it.height.meters}m\n"+
                    "First flight : ${it.firstFlight}\n"+
                    "Active : ${it.active}\n"+
                    "Stage : ${it.stage}\n"+
                    "Booster : ${it.boosters}\n"+
                    "Success rate : ${it.successRate}\n"+
                    "Country : ${it.country}\n"+
                    "Company : ${it.company}\n"+
                    "Wikipedia : ${it.wikipedia}\n"



        }
    }

    private fun handleLoading() {
        println("details_debug : Loading...")
        binding.layoutLoading.visibility = View.VISIBLE
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().applicationContext as BaseApplication).appComponent.newRocketDetailsSubComponent().inject(this)
    }

    override fun getLayoutId(): Int = R.layout.fragment_details_rocket

    override fun getViewModel(): Class<RocketDetailsViewModel> = RocketDetailsViewModel::class.java
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.save_btn -> saveRocket()
        }
    }

    private fun saveRocket() {
        viewModel.saveRocket(rocket)
        val bottomNavView: BottomNavigationView = requireActivity().findViewById(R.id.bottom_nav)
        Snackbar.make(bottomNavView, "${rocket.rocketName} Saved", Snackbar.LENGTH_LONG).apply {
            anchorView = bottomNavView
        }.show()
    }

}
