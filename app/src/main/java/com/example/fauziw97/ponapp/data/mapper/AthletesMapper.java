package com.example.fauziw97.ponapp.data.mapper;

import com.example.fauziw97.ponapp.data.entity.AthletesEntity;
import com.example.fauziw97.ponapp.data.model.Athletes;

public class AthletesMapper extends FirebaseMapper<AthletesEntity, Athletes> {
    @Override
    public Athletes map(AthletesEntity athletesEntity) {
        Athletes athletes = new Athletes();
        athletes.setAthletesImage(athletesEntity.getAthletesImage());
        athletes.setAthletesName(athletesEntity.getAthletesName());
        athletes.setAthletesContingent(athletesEntity.getAthletesContingent());
        athletes.setAthletesSex(athletesEntity.getAthletesSex());
        athletes.setAthletesSports(athletesEntity.getAthletesSports());
        athletes.setAthletesAge(athletesEntity.getAthletesAge());
        return athletes;
    }
}
