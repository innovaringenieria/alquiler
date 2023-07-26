package com.ejercicio.practico.alquiler.domain.usecase;

import com.ejercicio.practico.alquiler.domain.gateway.CarGateway;
import com.ejercicio.practico.alquiler.domain.model.Car;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CarUseCase {

    private final CarGateway carGateway;

    public void saveCar(Car car) {
        carGateway.saveCar(car);
    }

    public void deleteCar(Integer carId) {
        carGateway.deleteCar(carId);
    }

    public List<Car> allCars() {
        return carGateway.allCars();
    }

    public List<Car> retireesCar() {
        return carGateway.retireesCar();
    }
}
