package com.revisionboot.DemoF1driversApp.Service;

import com.revisionboot.DemoF1driversApp.Entity.Drivers;
import com.revisionboot.DemoF1driversApp.Repository.DriversRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DriversService {

    private final DriversRepo repository;

    public DriversService(DriversRepo repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Drivers> getAllDrivers() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Drivers getDriverById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Driver not found with ID: " + id));
    }

    @Transactional
    public Drivers createDriver(String name, BigDecimal worth) {
        Drivers driver = new Drivers(name, worth);
        return repository.save(driver);
    }

    @Transactional
    public Drivers updateDriver(Long id, String name, BigDecimal worth) {
        Drivers driver = getDriverById(id);
        driver.setName(name);
        driver.setWorth(worth);
        return repository.save(driver);
    }

    @Transactional
    public void deleteDriver(Long id) {
        Drivers driver = getDriverById(id);
        repository.delete(driver);
    }
}
