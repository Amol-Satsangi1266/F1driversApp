package com.revisionboot.DemoF1driversApp.Repository;

import com.revisionboot.DemoF1driversApp.Entity.Drivers;
import com.revisionboot.DemoF1driversApp.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<Drivers, Long> {

    Optional<Role> findByUsername(String name);
}
