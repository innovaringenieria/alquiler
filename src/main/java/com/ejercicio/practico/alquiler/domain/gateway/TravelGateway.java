package com.ejercicio.practico.alquiler.domain.gateway;

import com.ejercicio.practico.alquiler.domain.model.Travel;

import java.util.List;

public interface TravelGateway {

    void saveTravel(Integer employeeId, Integer carId);

    Travel deleteTravel(Integer employeeId, Integer carId);

    List<Travel> tripsMade(Integer month, Integer year);
}
