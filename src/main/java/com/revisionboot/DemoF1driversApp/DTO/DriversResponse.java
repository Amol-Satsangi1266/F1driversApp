package com.revisionboot.DemoF1driversApp.DTO;

import com.revisionboot.DemoF1driversApp.Entity.Drivers;

import java.math.BigDecimal;

public record DriversResponse(
        Long id,
        String name,
        BigDecimal worth
) {
    public static DriversResponse from(Drivers driver) {
        return new DriversResponse(
                driver.getId(),
                driver.getName(),
                driver.getWorth()
        );
    }
}