package com.example.fauziw97.ponapp.data.mapper;

import com.example.fauziw97.ponapp.data.entity.NewsEntity;
import com.example.fauziw97.ponapp.data.model.News;

public class NewsMapper extends FirebaseMapper<NewsEntity, News> {

    @Override
    public News map(NewsEntity newsEntity) {
        News news = new News();
        news.setNewsImage(newsEntity.getNewsImage());
        news.setNewsTitle(newsEntity.getNewsTitle());
        news.setNewsDate(newsEntity.getNewsDate());
        news.setNewsDesc(newsEntity.getNewsDesc());
        return news;
    }
}
