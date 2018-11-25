package com.example.fauziw97.ponapp.ui.medals

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fauziw97.ponapp.R
import com.example.fauziw97.ponapp.data.model.Medals
import kotlinx.android.synthetic.main.item_medals.view.*

class MedalsAdapter(private val medalsList: List<Medals>) : RecyclerView.Adapter<MedalsAdapter.MedalsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedalsViewHolder {
        return MedalsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_medals, parent, false))
    }

    override fun getItemCount(): Int = medalsList.size

    override fun onBindViewHolder(holder: MedalsViewHolder, position: Int) {
        holder.bind(medalsList[position])
    }

    inner class MedalsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(medals: Medals) {
            if (medals.rank % 2 == 0) {
                itemView.medalList.setBackgroundColor(Color.parseColor("#f2f2f2"))
            } else {
                itemView.medalList.setBackgroundColor(Color.WHITE)
            }
            itemView.rank.text = medals.rank.toString()
            itemView.contingent.text = medals.contingent
            itemView.goldCount.text = medals.gold.toString()
            itemView.silverCount.text = medals.silver.toString()
            itemView.bronzeCount.text = medals.bronze.toString()
            itemView.total.text = medals.total.toString()
        }
    }
}