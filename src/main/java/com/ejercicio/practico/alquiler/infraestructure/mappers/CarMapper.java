package com.ejercicio.practico.alquiler.infraestructure.mappers;

import com.ejercicio.practico.alquiler.domain.model.Car;
import com.ejercicio.practico.alquiler.infraestructure.entities.CarEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CarMapper extends EntityMapper<Car, CarEntity> {
}
