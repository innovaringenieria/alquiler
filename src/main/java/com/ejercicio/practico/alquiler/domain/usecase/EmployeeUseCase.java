package com.ejercicio.practico.alquiler.domain.usecase;

import com.ejercicio.practico.alquiler.domain.gateway.EmployeeGateway;
import com.ejercicio.practico.alquiler.domain.model.Employee;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class EmployeeUseCase {

    private final EmployeeGateway employeeGateway;

    public void saveEmployee(Employee employee) {
        employeeGateway.saveEmployee(employee);
    }

    public void deleteEmployee(Integer employeeId) {
        employeeGateway.deleteEmployee(employeeId);
    }

    public List<Employee> allEmployees() {
        return employeeGateway.allEmployees();
    }
}
