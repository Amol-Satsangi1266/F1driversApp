package com.revisionboot.DemoF1driversApp.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "drivers")
@Data
@NoArgsConstructor  // <--- Required by JPA / Hibernate for GET requests
@AllArgsConstructor
public class Drivers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120, unique = true)
    private String username;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal worth;

    @Column(nullable = false)
    private String password = "";

    private boolean enabled;

    @ManyToMany
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")

    )
    private Set<Role> roles;

    public Drivers(String name, BigDecimal worth) {
        this.username = name;
        this.worth = worth;
    }
}
