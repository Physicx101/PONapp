package com.example.fauziw97.ponapp.data.mapper;

import com.example.fauziw97.ponapp.data.entity.ScheduleEntity;
import com.example.fauziw97.ponapp.data.model.Schedule;

public class ScheduleMapper extends FirebaseMapper<ScheduleEntity, Schedule> {
    @Override
    public Schedule map(ScheduleEntity scheduleEntity) {
        Schedule schedule = new Schedule();
        schedule.setSportsName(scheduleEntity.getSportsName());
        schedule.setSportsImage(scheduleEntity.getSportsImage());
        schedule.setTimeA(scheduleEntity.getTimeA());
        schedule.setTimeB(scheduleEntity.getTimeB());
        schedule.setTimeC(scheduleEntity.getTimeC());
        schedule.setDate(scheduleEntity.getDate());
        return schedule;
    }
}
