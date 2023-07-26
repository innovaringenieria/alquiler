package com.ejercicio.practico.alquiler.infraestructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "viaje")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TravelEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer travelId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empleado_id", nullable = false)
    private EmployeeEntity employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carro_id", nullable = false)
    private CarEntity car;

    @Column(name = "data_retirada", nullable = false)
    private LocalDate retirementDate;

    @Column(name = "data_entrega")
    private LocalDate deliveryDate;
}
