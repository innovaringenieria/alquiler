package com.ejercicio.practico.alquiler.infraestructure.entrypoints;

import com.ejercicio.practico.alquiler.domain.model.Car;
import com.ejercicio.practico.alquiler.domain.usecase.CarUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping("/api/carros")
@RequiredArgsConstructor
public class CarRestController {

    private final CarUseCase carUseCase;

    @PostMapping
    public void save(@Valid @RequestBody Car car) {
        carUseCase.saveCar(car);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        carUseCase.deleteCar(id);
    }

    @GetMapping
    public List<Car> all() {
        return carUseCase.allCars();
    }

    @GetMapping("/retirados")
    public List<Car> retirees() {
        return carUseCase.retireesCar();
    }
}
