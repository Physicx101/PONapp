package com.example.fauziw97.ponapp.data.repo;

import com.example.fauziw97.ponapp.data.mapper.MedalsMapper;
import com.example.fauziw97.ponapp.data.model.Medals;

public class MedalsRepo extends FirebaseDatabaseRepo<Medals> {

    public MedalsRepo() {
        super(new MedalsMapper());
    }

    @Override
    protected String getRootNode() {
        return "medals";
    }

    @Override
    protected String getOrderBy() {
        return "rank";
    }
}
