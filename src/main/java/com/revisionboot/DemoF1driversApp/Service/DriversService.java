package com.revisionboot.DemoF1driversApp.Service;

import com.revisionboot.DemoF1driversApp.DTO.DriversRegisterRequest;
import com.revisionboot.DemoF1driversApp.DTO.DriversResponse;
import com.revisionboot.DemoF1driversApp.Entity.Drivers;
import com.revisionboot.DemoF1driversApp.Repository.DriversRepo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DriversService {

    private final DriversRepo repository;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public DriversService(DriversRepo repository) {

        this.repository = repository;
    }


    public List<Drivers> getAllDrivers() {
        return repository.findAll();
    }


    public Drivers getDriverById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Driver not found with ID: " + id));
    }


    public Drivers registerDriver(String name, String password) {
        String encodedPassword = passwordEncoder.encode(password);

        Drivers driver = new Drivers(name,encodedPassword);

        driver.setEnabled(true);

        return repository.save(driver);
    }


    public Drivers updateDriver(Long id, String name, BigDecimal worth) {
        Drivers driver = getDriverById(id);
        driver.setUsername(name);
        driver.setWorth(worth);
        return repository.save(driver);
    }


    public void deleteDriver(Long id) {
        Drivers driver = getDriverById(id);
        repository.delete(driver);
    }

}
