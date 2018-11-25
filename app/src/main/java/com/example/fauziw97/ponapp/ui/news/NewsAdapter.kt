package com.example.fauziw97.ponapp.ui.news

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.fauziw97.ponapp.R
import com.example.fauziw97.ponapp.data.model.News
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter(private val newsList: List<News>) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false))
    }

    override fun getItemCount(): Int = newsList.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(newsList[position])
    }

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(news: News) {
            Glide.with(itemView.context).load(news.newsImage).into(itemView.newsImage)
            itemView.newsImage.clipToOutline = true
            itemView.newsTitle.text = news.newsTitle
            itemView.newsDate.text = news.newsDate.toString() + " jam lalu"
        }
    }
}