package com.ejercicio.practico.alquiler.infraestructure.entrypoints;

import com.ejercicio.practico.alquiler.domain.model.Employee;
import com.ejercicio.practico.alquiler.domain.usecase.EmployeeUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping("/api/empleados")
@RequiredArgsConstructor
public class EmployeeRestController {

    private final EmployeeUseCase employeeUseCase;

    @CrossOrigin(origins = "*", allowedHeaders = {"Requestor-Type", "Authorization"}, exposedHeaders = "X-Get-Header")
    @PostMapping
    public void save(@Valid @RequestBody Employee employee) {
        employeeUseCase.saveEmployee(employee);
    }

    @CrossOrigin(origins = "*", allowedHeaders = {"Requestor-Type", "Authorization"}, exposedHeaders = "X-Get-Header")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        employeeUseCase.deleteEmployee(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = {"Requestor-Type", "Authorization"}, exposedHeaders = "X-Get-Header")
    @GetMapping
    public List<Employee> all() {
        return employeeUseCase.allEmployees();
    }
}
