package com.example.railwayinformationsystem.repository;

import com.example.railwayinformationsystem.model.entity.Department;
import com.example.railwayinformationsystem.model.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    @Query("select d.worker from Department d")
    public List<Worker> findAdministrators();

    @Query("select count(distinct d.worker) from Department d")
    public int countAdministrators();
}