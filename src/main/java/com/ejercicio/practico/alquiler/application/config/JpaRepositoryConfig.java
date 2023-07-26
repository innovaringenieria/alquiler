package com.ejercicio.practico.alquiler.application.config;

import com.ejercicio.practico.alquiler.domain.gateway.EmployeeGateway;
import com.ejercicio.practico.alquiler.infraestructure.entities.EmployeeEntity;
import com.ejercicio.practico.alquiler.infraestructure.mappers.EmployeeMapper;
import com.ejercicio.practico.alquiler.infraestructure.mappers.EmployeeMapperImpl;
import com.ejercicio.practico.alquiler.infraestructure.persistence.EmployeeGatewayImpl;
import com.ejercicio.practico.alquiler.infraestructure.persistence.JpaEmployeeRepository;
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
                EmployeeGatewayImpl.class
        }
)
@EnableJpaRepositories(
        basePackageClasses = {
                JpaEmployeeRepository.class
        }
)
@EntityScan(
        basePackageClasses = {
                EmployeeEntity.class
        }
)
@Log4j2
public class JpaRepositoryConfig {

    public JpaRepositoryConfig() {
        log.info("..::Starting Jpa Repositories configuration::..");
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
