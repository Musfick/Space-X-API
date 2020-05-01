package com.foxhole.spacex.ui.home

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.foxhole.spacex.BaseApplication
import com.foxhole.spacex.R
import com.foxhole.spacex.adapter.IRocketRecyclerAdapter
import com.foxhole.spacex.adapter.RocketRecyclerAdapter
import com.foxhole.spacex.base.BaseFragment
import com.foxhole.spacex.databinding.FragmentHomeBinding
import com.foxhole.spacex.model.rocket.Rocket
import com.foxhole.spacex.utils.Resource
import javax.inject.Inject

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(), IRocketRecyclerAdapter{

    @Inject
    lateinit var recyclerAdapter: RocketRecyclerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()

        observeAllRocket()
    }

    private fun initRecyclerView() {
        binding.recyclerView.apply {
            this.setHasFixedSize(true)
            this.layoutManager = LinearLayoutManager(context)
        }
    }

    private fun observeAllRocket() {
        viewModel.rockets.observe(viewLifecycleOwner, Observer {
            it?.let {
                when(it.status){
                    Resource.Status.LOADING -> handleLoading()
                    Resource.Status.SUCCESS -> handleSuccess(it.data)
                    Resource.Status.ERROR -> handleError(it.message)
                    Resource.Status.REFRESHING -> handleRefreshing()
                    Resource.Status.REFRESHED -> handleRefreshed(it.data)
                }
            }
        })
    }

    private fun handleRefreshed(data: MutableList<Rocket>?) {
        println("debug_home : Refreshed...")
        binding.layoutRefreshing.visibility = View.GONE
        updateRecyclerView(data)
    }

    private fun handleRefreshing() {
        println("debug_home : Refreshing...")
        binding.layoutRefreshing.visibility = View.VISIBLE
    }

    private fun handleError(message: String?) {
        println("debug_home : Error...")
        binding.layoutLoading.visibility = View.GONE
        binding.layoutError.visibility = View.VISIBLE
    }

    private fun handleSuccess(data: MutableList<Rocket>?) {
        println("debug_home : success...")
        binding.layoutRefreshing.visibility = View.GONE
        binding.layoutLoading.visibility = View.GONE
        updateRecyclerView(data)
    }

    private fun handleLoading() {
        println("debug_home : Loading...")
        binding.layoutLoading.visibility = View.VISIBLE
    }

    private fun updateRecyclerView(data: MutableList<Rocket>?) {
        data?.let {
            recyclerAdapter.addItems(it)
            recyclerAdapter.setOnClickListener(this)
            binding.recyclerView.adapter = recyclerAdapter
            binding.recyclerView.visibility = View.VISIBLE
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().applicationContext as BaseApplication).appComponent.newHomeSubComponent().inject(this)
    }

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun getViewModel(): Class<HomeViewModel> = HomeViewModel::class.java

    override fun onItemClick(rocket: Rocket) {
        println("debug_home : $rocket")
        val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(rocket.rocketId)
        findNavController().navigate(action)
    }

}
