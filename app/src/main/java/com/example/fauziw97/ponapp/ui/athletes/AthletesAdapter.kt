package com.example.fauziw97.ponapp.ui.athletes

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.fauziw97.ponapp.R
import com.example.fauziw97.ponapp.data.model.Athletes
import kotlinx.android.synthetic.main.item_athletes.view.*

class AthletesAdapter(private val athletesList: List<Athletes>) :
    RecyclerView.Adapter<AthletesAdapter.AthletesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AthletesViewHolder {
        return AthletesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_athletes, parent, false))
    }

    override fun getItemCount(): Int = athletesList.size

    override fun onBindViewHolder(holder: AthletesViewHolder, position: Int) {
        holder.bind(athletesList[position])
    }

    inner class AthletesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(athletes: Athletes) {
            Glide.with(itemView.context).load(athletes.athletesImage).into(itemView.athleteImage)
            itemView.athleteName.text = athletes.athletesName
            itemView.athleteContingent.text = athletes.athletesContingent
            itemView.athleteSex.text = athletes.athletesSex
            itemView.athleteSports.text = athletes.athletesSports
            itemView.athleteAge.text = athletes.athletesAge.toString() + " tahun"
        }
    }
}