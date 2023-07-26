package com.ejercicio.practico.alquiler.application.config;

import com.ejercicio.practico.alquiler.domain.gateway.CarGateway;
import com.ejercicio.practico.alquiler.domain.gateway.EmployeeGateway;
import com.ejercicio.practico.alquiler.domain.gateway.TravelGateway;
import com.ejercicio.practico.alquiler.domain.usecase.CarUseCase;
import com.ejercicio.practico.alquiler.domain.usecase.EmployeeUseCase;
import com.ejercicio.practico.alquiler.domain.usecase.TravelUseCase;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Log4j2
public class UseCaseConfig {
    public UseCaseConfig() {
        log.info("..::Starting use case configuration::..");
    }

    @Bean
    public TravelUseCase travelUseCase(TravelGateway travelGateway) {
        return new TravelUseCase(travelGateway);
    }

    @Bean
    public CarUseCase carUseCase(CarGateway carGateway) {
        return new CarUseCase(carGateway);
    }

    @Bean
    public EmployeeUseCase employeeUseCase(EmployeeGateway employeeGateway) {
        return new EmployeeUseCase(employeeGateway);
    }
}
