package com.ejercicio.practico.alquiler.domain.gateway;

import com.ejercicio.practico.alquiler.domain.model.Car;

import java.util.List;

public interface CarGateway {

    void saveCar(Car car);

    void deleteCar(Integer carId);

    List<Car> allCars();

    List<Car> retireesCar();
}
