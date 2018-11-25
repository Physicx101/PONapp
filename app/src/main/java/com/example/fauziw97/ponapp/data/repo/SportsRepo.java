package com.example.fauziw97.ponapp.data.repo;

import com.example.fauziw97.ponapp.data.mapper.SportsMapper;
import com.example.fauziw97.ponapp.data.model.Sports;

public class SportsRepo extends FirebaseDatabaseRepo<Sports> {

    public SportsRepo() {
        super(new SportsMapper());
    }

    @Override
    protected String getRootNode() {
        return "sports";
    }

    @Override
    protected String getOrderBy() {
        return "sportsName";
    }
}
