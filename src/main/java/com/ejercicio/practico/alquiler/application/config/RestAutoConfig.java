package com.ejercicio.practico.alquiler.application.config;

import com.ejercicio.practico.alquiler.infraestructure.entrypoints.AuthRestController;
import com.ejercicio.practico.alquiler.infraestructure.entrypoints.CarRestController;
import com.ejercicio.practico.alquiler.infraestructure.entrypoints.EmployeeRestController;
import com.ejercicio.practico.alquiler.infraestructure.entrypoints.TravelRestController;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureBefore({ValidationAutoConfiguration.class})
@ComponentScan(
        basePackageClasses = {
                AuthRestController.class,
                EmployeeRestController.class,
                CarRestController.class,
                TravelRestController.class
        }
)
@Log4j2
public class RestAutoConfig {
        public RestAutoConfig() {
                log.info("..::Starting Rest controller configuration::..");
        }
}
