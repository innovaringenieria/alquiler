package com.ejercicio.practico.alquiler.application.config;

import com.ejercicio.practico.alquiler.application.AppMessageSource;
import com.ejercicio.practico.alquiler.domain.gateway.CarGateway;
import com.ejercicio.practico.alquiler.domain.gateway.EmployeeGateway;
import com.ejercicio.practico.alquiler.domain.gateway.TravelGateway;
import com.ejercicio.practico.alquiler.infraestructure.entities.CarEntity;
import com.ejercicio.practico.alquiler.infraestructure.entities.EmployeeEntity;
import com.ejercicio.practico.alquiler.infraestructure.entities.TravelEntity;
import com.ejercicio.practico.alquiler.infraestructure.mappers.CarMapper;
import com.ejercicio.practico.alquiler.infraestructure.mappers.EmployeeMapper;
import com.ejercicio.practico.alquiler.infraestructure.mappers.TravelMapper;
import com.ejercicio.practico.alquiler.infraestructure.persistence.*;
import lombok.extern.log4j.Log4j2;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(
        basePackageClasses = {
                EmployeeGatewayImpl.class,
                CarGatewayImpl.class,
                TravelGatewayImpl.class
        }
)
@EnableJpaRepositories(
        basePackageClasses = {
                JpaEmployeeRepository.class,
                JpaCarRepository.class,
                JpaTravelRepository.class
        }
)
@EntityScan(
        basePackageClasses = {
                EmployeeEntity.class,
                CarEntity.class,
                TravelEntity.class
        }
)
@Log4j2
public class JpaRepositoryConfig {

    public JpaRepositoryConfig() {
        log.info("..::Starting Jpa Repositories configuration::..");
    }

    @Bean
    public TravelMapper travelMapper() {
        return Mappers.getMapper(TravelMapper.class);
    }

    @Bean
    public TravelGateway travelGateway(JpaTravelRepository repository, TravelMapper mapper,
                                       JpaEmployeeRepository employeeRepository, EmployeeMapper employeeMapper,
                                       JpaCarRepository carRepository, CarMapper carMapper,
                                       AppMessageSource messageSource) {
        return new TravelGatewayImpl(repository, mapper, employeeRepository, employeeMapper, carRepository, carMapper, messageSource);
    }

    @Bean
    public CarMapper carMapper() {
        return Mappers.getMapper(CarMapper.class);
    }

    @Bean
    public CarGateway carGateway(JpaCarRepository repository, CarMapper mapper) {
        return new CarGatewayImpl(repository, mapper);
    }

    @Bean
    public EmployeeMapper employeeMapper() {
        return Mappers.getMapper(EmployeeMapper.class);
    }

    @Bean
    public EmployeeGateway employeeGateway(JpaEmployeeRepository repository, EmployeeMapper mapper) {
        return new EmployeeGatewayImpl(repository, mapper);
    }
}
