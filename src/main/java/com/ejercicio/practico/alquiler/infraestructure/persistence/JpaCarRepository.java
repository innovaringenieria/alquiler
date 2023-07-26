package com.ejercicio.practico.alquiler.infraestructure.persistence;

import com.ejercicio.practico.alquiler.infraestructure.entities.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCarRepository extends JpaRepository<CarEntity, Integer> {
}
