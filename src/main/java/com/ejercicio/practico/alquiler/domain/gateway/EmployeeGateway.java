package com.ejercicio.practico.alquiler.domain.gateway;

import com.ejercicio.practico.alquiler.domain.model.Employee;

import java.util.List;

public interface EmployeeGateway {

    void saveEmployee(Employee employee);

    void deleteEmployee(Integer employeeId);

    List<Employee> allEmployees();
}
