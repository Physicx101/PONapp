package com.example.fauziw97.ponapp.data.repo;

import com.example.fauziw97.ponapp.data.mapper.NewsMapper;
import com.example.fauziw97.ponapp.data.model.News;

public class NewsRepo extends FirebaseDatabaseRepo<News> {

    public NewsRepo() {
        super(new NewsMapper());
    }

    @Override
    protected String getRootNode() {
        return "news";
    }

    @Override
    protected String getOrderBy() {
        return "newsDate";
    }
}