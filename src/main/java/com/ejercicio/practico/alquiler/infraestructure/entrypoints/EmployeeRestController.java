package com.ejercicio.practico.alquiler.infraestructure.entrypoints;

import com.ejercicio.practico.alquiler.domain.model.Employee;
import com.ejercicio.practico.alquiler.domain.usecase.EmployeeUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
@RequiredArgsConstructor
public class EmployeeRestController {

    private final EmployeeUseCase employeeUseCase;

    @PostMapping
    public void save(@Valid @RequestBody Employee employee) {
        employeeUseCase.saveEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        employeeUseCase.deleteEmployee(id);
    }

    @GetMapping
    public List<Employee> all() {
        return employeeUseCase.allEmployees();
    }
}
