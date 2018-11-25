package com.example.fauziw97.ponapp.data.mapper;

import com.example.fauziw97.ponapp.data.entity.MedalsEntity;
import com.example.fauziw97.ponapp.data.model.Medals;

public class MedalsMapper extends FirebaseMapper<MedalsEntity, Medals> {

    @Override
    public Medals map(MedalsEntity medalsEntity) {
        Medals medals = new Medals();
        medals.setContingent(medalsEntity.getContingent());
        medals.setGold(medalsEntity.getGold());
        medals.setSilver(medalsEntity.getSilver());
        medals.setBronze(medalsEntity.getBronze());
        medals.setTotal(medalsEntity.getTotal());
        medals.setRank(medalsEntity.getRank());
        return medals;
    }
}
