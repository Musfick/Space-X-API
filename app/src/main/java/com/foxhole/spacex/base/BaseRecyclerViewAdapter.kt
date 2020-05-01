package com.foxhole.spacex.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


/**
 * Created by Musfick Jamil on 4/29/2020$.
 */
abstract class BaseRecyclerViewAdapter<T> : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    var items = mutableListOf<T>()

    fun addItems(items : MutableList<T>){
        this.items = items
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int =items.size
    abstract fun getLayoutId(): Int

    abstract fun setViewHolder(view: View): RecyclerView.ViewHolder

    abstract fun onBindData(holder: RecyclerView.ViewHolder?, item: T)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(getLayoutId(), parent, false)
        return setViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        onBindData(holder,items.get(position));
    }
}