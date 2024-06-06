package com.example.railwayinformationsystem.repository;

import com.example.railwayinformationsystem.model.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver, Integer> {
    @Query("select d from Driver d where d.medicalExamination >= ?1")
    List<Driver> findAllPassedMedicalExamination(Short medicalExamination);

    @Query("select count(d) from Driver d where d.medicalExamination >= ?1")
    int countAllPassedMedicalExamination(Short medicalExamination);

    @Query("select d from Driver d where d.medicalExamination < ?1")
    List<Driver> findAllFailedMedicalExamination(Short medicalExamination);

    @Query("select count(d) from Driver d where d.medicalExamination < ?1")
    int countAllFailedMedicalExamination(Short medicalExamination);

    @Query("select d from Driver d join Worker w on w.id = d.worker.id where w.gender = ?1")
    List<Driver> findAllByGender(Character gender);

    @Query("select count(d) from Driver d join Worker w on w.id = d.worker.id where w.gender = ?1")
    int countAllByGender(Character gender);

    @Query("select d from Driver d join Worker w on d.worker.id = w.id where w.age = ?1")
    List<Driver> findAllByAge(Short age);

    @Query("select count(d) from Driver d join Worker w on d.worker.id = w.id where w.age = ?1")
    int countAllByAge(Short age);

    @Query("select d from Driver d join Worker w on w.id = d.worker.id where w.salary > ?1")
    List<Driver> findAllBySalary(Integer salary);

    @Query("select count(d) from Driver d join Worker w on w.id = d.worker.id where w.salary > ?1")
    int countAllBySalary(Integer salary);

}