package com.ejercicio.practico.alquiler.infraestructure.mappers;

import com.ejercicio.practico.alquiler.domain.model.Travel;
import com.ejercicio.practico.alquiler.infraestructure.entities.TravelEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {EmployeeMapper.class, CarMapper.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface TravelMapper extends EntityMapper<Travel, TravelEntity> {
}
