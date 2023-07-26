package com.ejercicio.practico.alquiler.infraestructure.persistence;

import com.ejercicio.practico.alquiler.infraestructure.entities.TravelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaTravelRepository extends JpaRepository<TravelEntity, Integer> {

    @Query("from TravelEntity e where e.employee.employeeId = :employeeId and e.car.carId = :carId and e.deliveryDate is null")
    Optional<TravelEntity> deleteTravel(@Param("employeeId") Integer employeeId, @Param("carId") Integer carId);

}
