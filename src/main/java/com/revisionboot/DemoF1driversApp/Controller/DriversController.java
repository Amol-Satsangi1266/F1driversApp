package com.revisionboot.DemoF1driversApp.Controller;

import com.revisionboot.DemoF1driversApp.DTO.DriversRequest;
import com.revisionboot.DemoF1driversApp.DTO.DriversResponse;
import com.revisionboot.DemoF1driversApp.Entity.Drivers;
import com.revisionboot.DemoF1driversApp.Service.DriversService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/drivers")
public class DriversController {

    private final DriversService service;

    public DriversController(DriversService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DriversResponse create(
            @Valid @RequestBody DriversRequest request) {

        Drivers driver = service.createDriver(
                request.name(), request.worth()
        );

        return DriversResponse.from(driver);
    }

    @GetMapping
    public List<DriversResponse> getAll() {
        return service.getAllDrivers()
                .stream()
                .map(DriversResponse::from)
                .toList();
    }

    @GetMapping("/{id}")
    public DriversResponse getOne(@PathVariable Long id) {
        return DriversResponse.from(
                service.getDriverById(id));
    }

    @PutMapping("/{id}")
    public DriversResponse update(
            @PathVariable Long id,
            @Valid @RequestBody DriversRequest request) {

        Drivers updated = service.updateDriver(
                id, request.name(), request.worth()
        );

        return DriversResponse.from(updated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.deleteDriver(id);
    }

    @GetMapping("/csrf")
    public CsrfToken csrfToken(CsrfToken token)
    {
        return token;
    }
}
