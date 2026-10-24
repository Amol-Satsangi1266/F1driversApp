package com.revisionboot.DemoF1driversApp.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "drivers")
@Data
public class Drivers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String name;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal worth;

    public Drivers(String name, BigDecimal worth) {
        this.name = name;
        this.worth = worth;
    }
}
