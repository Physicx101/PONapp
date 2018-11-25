package com.example.fauziw97.ponapp.data.mapper;

import com.example.fauziw97.ponapp.data.entity.SportsEntity;
import com.example.fauziw97.ponapp.data.model.Sports;

public class SportsMapper extends FirebaseMapper<SportsEntity, Sports> {

    @Override
    public Sports map(SportsEntity sportsEntity) {
        Sports sports = new Sports();
        sports.setSportsImage(sportsEntity.getSportsImage());
        sports.setSportsName(sportsEntity.getSportsName());
        return sports;
    }
}
