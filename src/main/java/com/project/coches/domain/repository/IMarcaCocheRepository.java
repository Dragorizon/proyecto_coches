package com.project.coches.domain.repository;

import com.project.coches.domain.dto.MarcaCocheDto;

import java.util.List;
import java.util.Optional;

public interface IMarcaCocheRepository {

    /**
     * Devuelve una lista de todas las marcas de coches
     * @return Lista de marcas de coches
     */
    List<MarcaCocheDto> getAll();

    /**
     * Devuelve una marca de coche dada su id
     * @param id Id de marca coche
     * @return Optional del marca coche encontrado
     */
    Optional<MarcaCocheDto> getMarcaCoche(Integer id);

    /**
     * Guarda una nueva marca coche
     * @param newMarcaCoche Marca coche a guardar
     * @return Marca coche guardada
     */
    MarcaCocheDto save(MarcaCocheDto newMarcaCoche);

    /**
     * Elimina una marca coche dada su id
     * @param idMarcaCoche Id del marca coche a eliminar
     */
    void delete(Integer idMarcaCoche);
}
