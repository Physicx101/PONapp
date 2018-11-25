package com.example.fauziw97.ponapp.ui.sports

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.fauziw97.ponapp.R
import com.example.fauziw97.ponapp.data.model.Sports
import kotlinx.android.synthetic.main.item_sports.view.*

class SportsAdapter(private val sportsList: List<Sports>) : RecyclerView.Adapter<SportsAdapter.SportsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportsViewHolder {
        return SportsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_sports, parent, false))
    }

    override fun getItemCount(): Int = sportsList.size

    override fun onBindViewHolder(holder: SportsViewHolder, position: Int) {
        holder.bind(sportsList[position])
    }

    inner class SportsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(sports: Sports) {
            Glide.with(itemView.context).load(sports.sportsImage).into(itemView.sportsImage)
            itemView.sportsName.text = sports.sportsName
        }
    }
}