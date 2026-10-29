package com.revisionboot.DemoF1driversApp.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "drivers")
@Data
@NoArgsConstructor  // <--- Required by JPA / Hibernate for GET requests
@AllArgsConstructor
public class Drivers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String name;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal worth;

    @Column(nullable = false)
    private String password = "";

    private boolean enabled;

    public Drivers(String name, BigDecimal worth) {
        this.name = name;
        this.worth = worth;
    }
}
