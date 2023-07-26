package com.ejercicio.practico.alquiler.infraestructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "carro")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CarEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer carId;

    @Column(name = "modelo", nullable = false)
    private String model;

    @Column(name = "marca", nullable = false)
    private String brand;

    @Column(name = "data_fabricacao", nullable = false)
    private LocalDate productionDate;
}
