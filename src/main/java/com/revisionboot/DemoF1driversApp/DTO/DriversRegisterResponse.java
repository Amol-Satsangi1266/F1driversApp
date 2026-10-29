package com.revisionboot.DemoF1driversApp.DTO;

import com.revisionboot.DemoF1driversApp.Entity.Drivers;

public record DriversRegisterResponse(
        String name
) {
    public static DriversRegisterResponse from(Drivers driver) {
        return new DriversRegisterResponse(driver.getUsername());
    }
}