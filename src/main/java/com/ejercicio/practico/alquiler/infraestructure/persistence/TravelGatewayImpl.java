package com.ejercicio.practico.alquiler.infraestructure.persistence;

import com.ejercicio.practico.alquiler.application.AppMessageSource;
import com.ejercicio.practico.alquiler.application.exception.NotFoundException;
import com.ejercicio.practico.alquiler.domain.gateway.TravelGateway;
import com.ejercicio.practico.alquiler.domain.model.Car;
import com.ejercicio.practico.alquiler.domain.model.Employee;
import com.ejercicio.practico.alquiler.domain.model.Travel;
import com.ejercicio.practico.alquiler.infraestructure.entities.CarEntity;
import com.ejercicio.practico.alquiler.infraestructure.entities.EmployeeEntity;
import com.ejercicio.practico.alquiler.infraestructure.entities.TravelEntity;
import com.ejercicio.practico.alquiler.infraestructure.mappers.CarMapper;
import com.ejercicio.practico.alquiler.infraestructure.mappers.EmployeeMapper;
import com.ejercicio.practico.alquiler.infraestructure.mappers.TravelMapper;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
public class TravelGatewayImpl implements TravelGateway {

    private final JpaTravelRepository repository;
    private final TravelMapper mapper;
    private final JpaEmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final JpaCarRepository carRepository;
    private final CarMapper carMapper;
    private final AppMessageSource messageSource;

    @Override
    public void saveTravel(Integer employeeId, Integer carId) {
        TravelEntity entity = mapper.toEntity(Travel.builder()
                .employee(getEmployee(employeeId))
                .car(getCar(carId))
                .retirementDate(LocalDate.now())
                .build());
        repository.saveAndFlush(entity);
    }

    @Override
    public Travel deleteTravel(Integer employeeId, Integer carId) {
        TravelEntity travel = repository.deleteTravel(employeeId, carId).orElseThrow(() -> new NotFoundException(messageSource.getMessage("error.travel.notfound.exception", new Object[]{employeeId, carId})));
        travel.setDeliveryDate(LocalDate.now());
        return mapper.toDto(repository.save(travel));
    }

    @Override
    public List<Travel> tripsMade(Integer month, Integer year) {
        return null;
    }

    private Employee getEmployee(Integer employeeId) {
        EmployeeEntity employee = employeeRepository.findById(employeeId).orElseThrow(() -> new NotFoundException(messageSource.getMessage("error.employee.notfound.exception", new Object[]{employeeId})));
        return employeeMapper.toDto(employee);
    }

    private Car getCar(Integer carId) {
        CarEntity car = carRepository.findById(carId).orElseThrow(() -> new NotFoundException(messageSource.getMessage("error.car.notfound.exception", new Object[]{carId})));
        return carMapper.toDto(car);
    }
}
