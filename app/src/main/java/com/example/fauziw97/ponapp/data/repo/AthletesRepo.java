package com.example.fauziw97.ponapp.data.repo;

import com.example.fauziw97.ponapp.data.mapper.AthletesMapper;
import com.example.fauziw97.ponapp.data.model.Athletes;

public class AthletesRepo extends FirebaseDatabaseRepo<Athletes> {

    public AthletesRepo() {
        super(new AthletesMapper());
    }

    @Override
    protected String getRootNode() {
        return "athletes";
    }

    @Override
    protected String getOrderBy() {
        return "athletesName";
    }
}
