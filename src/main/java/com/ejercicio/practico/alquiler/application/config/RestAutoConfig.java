package com.ejercicio.practico.alquiler.application.config;

import com.ejercicio.practico.alquiler.infraestructure.entrypoints.AuthRestController;
import com.ejercicio.practico.alquiler.infraestructure.entrypoints.EmployeeRestController;
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
                EmployeeRestController.class
        }
)
@Log4j2
public class RestAutoConfig {
        public RestAutoConfig() {
                log.info("..::Starting rest controller configuration::..");
        }
}
