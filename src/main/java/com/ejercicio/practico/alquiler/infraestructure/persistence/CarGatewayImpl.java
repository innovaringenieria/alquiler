package com.ejercicio.practico.alquiler.infraestructure.persistence;

import com.ejercicio.practico.alquiler.domain.gateway.CarGateway;
import com.ejercicio.practico.alquiler.domain.model.Car;
import com.ejercicio.practico.alquiler.infraestructure.mappers.CarMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CarGatewayImpl implements CarGateway {

    private final JpaCarRepository repository;
    private final CarMapper mapper;
    @Override
    public void saveCar(Car car) {
        repository.save(mapper.toEntity(car));
    }

    @Override
    public void deleteCar(Integer carId) {
        repository.deleteById(carId);
    }

    @Override
    public List<Car> allCars() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public List<Car> retireesCar() {
        return null;
    }
}
