package com.project.coches.domain.useCase;

import com.project.coches.domain.dto.ClienteDto;
import com.project.coches.domain.dto.CocheDto;

import java.util.List;
import java.util.Optional;

public interface ICocheService {

    /**
     * Devuelve una lista de todas las marcas de coches
     * @return Lista de marcas de coches
     */
    List<CocheDto> getAll();


    List<CocheDto> getByIdMarcaCoche(Integer idCoche);


    List<CocheDto> getCochesByPriceLessThan(Double price);

    /**
     * Devuelve una marca de coche dada su id
     * @param idCoche Id de marca coche
     * @return Optional del marca coche encontrado
     */
    Optional<CocheDto> getCoche(Integer idCoche);

    /**
     * Guarda una nueva marca coche
     * @param newCoche Marca coche a guardar
     * @return Marca coche guardada
     */
    CocheDto save(CocheDto newCoche);


    Optional<CocheDto> update(CocheDto modifyCoche);

    /**
     * Elimina una marca coche dada su id
     * @param idCoche Id del marca coche a eliminar
     */
    Boolean delete(Integer idCoche);
}
