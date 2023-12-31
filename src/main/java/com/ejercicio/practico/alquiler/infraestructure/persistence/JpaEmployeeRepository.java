package com.ejercicio.practico.alquiler.infraestructure.persistence;

import com.ejercicio.practico.alquiler.infraestructure.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaEmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
}
