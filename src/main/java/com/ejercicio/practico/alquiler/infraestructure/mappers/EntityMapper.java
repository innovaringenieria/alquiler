package com.ejercicio.practico.alquiler.infraestructure.mappers;

import java.util.List;

public interface EntityMapper <D, E> {

    E toEntity(D dto);

    D toDto(E entity);

    List<D> toDto(List<E> entityList);
}
