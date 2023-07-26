package com.ejercicio.practico.alquiler.domain.usecase;

import com.ejercicio.practico.alquiler.domain.gateway.TravelGateway;
import com.ejercicio.practico.alquiler.domain.model.Travel;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TravelUseCase {

    private final TravelGateway travelGateway;

    public void saveTravel(Integer employeeId, Integer carId) {
        travelGateway.saveTravel(employeeId, carId);
    }

    public Travel deleteTravel(Integer employeeId, Integer carId) {
        return travelGateway.deleteTravel(employeeId, carId);
    }

    public List<Travel> tripsMade(Integer month, Integer year) {
        return travelGateway.tripsMade(month, year);
    }
}
