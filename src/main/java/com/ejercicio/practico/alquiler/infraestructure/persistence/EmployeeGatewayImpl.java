package com.ejercicio.practico.alquiler.infraestructure.persistence;

import com.ejercicio.practico.alquiler.domain.gateway.EmployeeGateway;
import com.ejercicio.practico.alquiler.domain.model.Employee;
import com.ejercicio.practico.alquiler.infraestructure.mappers.EmployeeMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class EmployeeGatewayImpl implements EmployeeGateway {

    private final JpaEmployeeRepository repository;
    private final EmployeeMapper mapper;
    @Override
    public void saveEmployee(Employee employee) {
        repository.save(mapper.toEntity(employee));
    }

    @Override
    public void deleteEmployee(Integer employeeId) {
        repository.deleteById(employeeId);
    }

    @Override
    public List<Employee> allEmployees() {
        return mapper.toDto(repository.findAll());
    }
}
