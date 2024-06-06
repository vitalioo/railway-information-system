package com.example.railwayinformationsystem.service;

import com.example.railwayinformationsystem.model.entity.Driver;

import java.util.List;

public interface DriverService {
    Driver getById(Integer id);

    Driver getDtoById(Integer id);


    void deleteById(Integer id);

    void save(Driver driver);

    List<Driver> getAll();

    void update(Driver driver);

    List<Driver> getAllPassedMedicalExamination(Short medicalExamination);

    int getCountAllPassedMedicalExamination(Short medicalExamination);

    List<Driver> getAllFailedMedicalExamination(Short medicalExamination);

    int getCountAllFailedMedicalExamination(Short medicalExamination);

    List<Driver> getAllByGender(Character gender);

    int getCountAllByGender(Character gender);

    List<Driver> getAllByAge(Short age);

    int getCountAllByAge(Short age);

    List<Driver> getAllBySalary(Integer salary);

    int getCountAllBySalary(Integer salary);
}
