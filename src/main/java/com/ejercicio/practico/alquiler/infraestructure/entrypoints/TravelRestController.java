package com.ejercicio.practico.alquiler.infraestructure.entrypoints;

import com.ejercicio.practico.alquiler.domain.model.Travel;
import com.ejercicio.practico.alquiler.domain.usecase.TravelUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping("/api/viaje")
@RequiredArgsConstructor
public class TravelRestController {

    private final TravelUseCase travelUseCase;

    @CrossOrigin(origins = "*", allowedHeaders = {"Requestor-Type", "Authorization"}, exposedHeaders = "X-Get-Header")
    @PostMapping("/{employeeId}/{carId}")
    public void save(@PathVariable Integer employeeId, @PathVariable Integer carId) {
        travelUseCase.saveTravel(employeeId, carId);
    }

    @CrossOrigin(origins = "*", allowedHeaders = {"Requestor-Type", "Authorization"}, exposedHeaders = "X-Get-Header")
    @DeleteMapping("/{employeeId}/{carId}")
    public Travel delete(@PathVariable Integer employeeId, @PathVariable Integer carId) {
        return travelUseCase.deleteTravel(employeeId, carId);
    }

    @CrossOrigin(origins = "*", allowedHeaders = {"Requestor-Type", "Authorization"}, exposedHeaders = "X-Get-Header")
    @GetMapping("/{month}/{year}")
    public List<Travel> trips(@PathVariable Integer month, @PathVariable Integer year) {
        return travelUseCase.tripsMade(month, year);
    }
}
