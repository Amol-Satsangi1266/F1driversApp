package com.revisionboot.DemoF1driversApp.DTO;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record DriversRequest(
        @NotBlank
        @Size(max = 120)
        String name,

        @NotNull
        @DecimalMin(value = "0.01")
        BigDecimal worth

) {
}