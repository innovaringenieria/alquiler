package com.ejercicio.practico.alquiler.infraestructure.persistence;

import com.ejercicio.practico.alquiler.infraestructure.entities.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaCarRepository extends JpaRepository<CarEntity, Integer> {

    @Query("select e.car from TravelEntity e where e.deliveryDate is null")
    List<CarEntity> retireesCar();
}
