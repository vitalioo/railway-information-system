package com.example.railwayinformationsystem.repository;

import com.example.railwayinformationsystem.model.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    @Query("select count(s.ticketsReturned) from Schedule s join s.route r where r.initialDestination = ?1 and r.finalDestination = ?2")
    int countReturnedTicketsByRoute(String initialDestination, String finalDestination);
}