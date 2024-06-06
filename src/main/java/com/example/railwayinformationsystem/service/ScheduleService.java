package com.example.railwayinformationsystem.service;

import com.example.railwayinformationsystem.model.entity.Schedule;

import java.util.List;

public interface ScheduleService {
    Schedule getById(Integer id);

    void deleteById(Integer id);

    void save(Schedule schedule);

    List<Schedule> getAll();

    void update(Schedule schedule);

    int getCountReturnedTicketsByRoute(String initialDestination, String finalDestination);
}
