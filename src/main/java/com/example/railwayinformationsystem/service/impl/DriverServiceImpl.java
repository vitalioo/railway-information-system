package com.example.railwayinformationsystem.service.impl;

import com.example.railwayinformationsystem.exception.DriverNotFoundException;
import com.example.railwayinformationsystem.model.entity.Driver;
import com.example.railwayinformationsystem.repository.DriverRepository;
import com.example.railwayinformationsystem.service.DriverService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {
    private final DriverRepository driverRepository;
    private final ModelMapper modelMapper;

    @Override
    public Driver getById(Integer id) {
        return driverRepository.findById(id).orElseThrow(() -> new DriverNotFoundException("Driver with id " + id + " not found"));
    }

    @Override
    public Driver getDtoById(Integer id) {
        return modelMapper.map(getById(id), Driver.class);
    }

    @Override
    public void deleteById(Integer id) {
        Driver driver = getById(id);
        driverRepository.deleteById(id);
        log.debug("Driver with id {} deleted", driver.getId());
    }

    @Override
    public void save(Driver driver) {
        driverRepository.save(driver);
        log.debug("Driver with id {} saved", driver.getId());
    }

    @Override
    public List<Driver> getAll() {
        List<Driver> drivers = driverRepository.findAll();
        log.debug("{} drivers found", drivers.size());
        return drivers;
    }

    @Override
    public void update(Driver driver) {
        Driver dbDriver = driverRepository.findById(driver.getId()).orElseThrow(() -> new DriverNotFoundException("Driver with id " + driver.getId() + " not found"));
        modelMapper.map(driver, dbDriver);
        driverRepository.save(dbDriver);
        log.debug("Driver with id {} updated", driver.getId());
    }

    @Override
    public List<Driver> getAllPassedMedicalExamination(Short medicalExamination) {
        return driverRepository.findAllPassedMedicalExamination(medicalExamination);
    }

    @Override
    public int getCountAllPassedMedicalExamination(Short medicalExamination) {
        return driverRepository.countAllPassedMedicalExamination(medicalExamination);
    }

    @Override
    public List<Driver> getAllFailedMedicalExamination(Short medicalExamination) {
        List<Driver> drivers = driverRepository.findAllFailedMedicalExamination(medicalExamination);
        log.debug("{} drivers found", drivers.size());
        return drivers;
    }

    @Override
    public int getCountAllFailedMedicalExamination(Short medicalExamination) {
        return driverRepository.countAllFailedMedicalExamination(medicalExamination);
    }

    @Override
    public List<Driver> getAllByGender(Character gender) {
        List<Driver> drivers = driverRepository.findAllByGender(gender);
        log.debug("{} drivers found with gender {}", drivers.size(), gender);
        return drivers;
    }

    @Override
    public int getCountAllByGender(Character gender) {
        return driverRepository.countAllByGender(gender);
    }

    @Override
    public List<Driver> getAllByAge(Short age) {
        List<Driver> drivers = driverRepository.findAllByAge(age);
        log.debug("{} drivers found with age {}", drivers.size(), age);
        return drivers;
    }

    @Override
    public int getCountAllByAge(Short age) {
        return driverRepository.countAllByAge(age);
    }

    @Override
    public List<Driver> getAllBySalary(Integer salary) {
        List<Driver> drivers = driverRepository.findAllBySalary(salary);
        log.debug("{} drivers found with salary {}", drivers.size(), salary);
        return drivers;
    }

    @Override
    public int getCountAllBySalary(Integer salary) {
        return driverRepository.countAllBySalary(salary);
    }
}
