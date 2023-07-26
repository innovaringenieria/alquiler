package com.ejercicio.practico.alquiler.infraestructure.mappers;

import com.ejercicio.practico.alquiler.domain.model.Employee;
import com.ejercicio.practico.alquiler.infraestructure.entities.EmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeMapper extends EntityMapper<Employee, EmployeeEntity> {
}
