package com.revisionboot.DemoF1driversApp.Repository;

import com.revisionboot.DemoF1driversApp.Entity.Drivers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriversRepo extends JpaRepository<Drivers, Long> {

}
