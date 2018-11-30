package com.example.fauziw97.ponapp.data.repo;

import com.example.fauziw97.ponapp.data.mapper.ScheduleMapper;
import com.example.fauziw97.ponapp.data.model.Schedule;

public class ScheduleRepo extends FirebaseDatabaseRepo<Schedule> {

    public ScheduleRepo() {
        super(new ScheduleMapper());
    }

    @Override
    protected String getRootNode() {
        return "schedule";
    }

    @Override
    protected String getOrderBy() {
        return "date";
    }
}
