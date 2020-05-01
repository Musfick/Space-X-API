package com.foxhole.spacex.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.foxhole.spacex.R
import com.foxhole.spacex.base.BaseRecyclerViewAdapter
import com.foxhole.spacex.model.rocket.Rocket
import com.google.android.material.card.MaterialCardView
import kotlinx.android.synthetic.main.layout_item_rocket.view.*

/**
 * Created by Musfick Jamil on 4/29/2020$.
 */
class RocketRecyclerAdapter : BaseRecyclerViewAdapter<Rocket>() {

    lateinit var iRocketRecyclerAdapter : IRocketRecyclerAdapter

    fun setOnClickListener(value : IRocketRecyclerAdapter){
        iRocketRecyclerAdapter = value
    }


    override fun getLayoutId(): Int =
        R.layout.layout_item_rocket

    override fun setViewHolder(view: View): RecyclerView.ViewHolder = RocketViewHolder(view)

    override fun onBindData(holder: RecyclerView.ViewHolder?, item: Rocket) {
        val mainHolder = holder as RocketViewHolder
        mainHolder.name.text = item.rocketName
        mainHolder.cost.text = "Cost : ${item.costPerLaunch}$"
        mainHolder.weight.text = "Weight : ${item.mass.kg/1000}Kg"
        mainHolder.height.text = "Height : ${item.height.meters}m"
        mainHolder.imageView.load(item.flickrImages[0])
    }

    //using inner is bad practice for recycler view
    inner class RocketViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name : TextView = itemView.rocketName
        val cost : TextView = itemView.launchCost
        val weight : TextView = itemView.rocketWeight
        val height : TextView = itemView.rocketHeight
        val imageView : ImageView = itemView.imageView
        val cardView : MaterialCardView = itemView.cardView
        init {
            cardView.setOnClickListener {
                iRocketRecyclerAdapter.onItemClick(items[adapterPosition])
            }
        }
    }


}