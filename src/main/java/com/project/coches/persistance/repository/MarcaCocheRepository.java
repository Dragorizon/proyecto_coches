package com.project.coches.persistance.repository;

import com.project.coches.domain.dto.MarcaCocheDto;
import com.project.coches.domain.repository.IMarcaCocheRepository;
import com.project.coches.persistance.entity.MarcaCocheEntity;
import com.project.coches.persistance.mapper.IMarcaCocheMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio de marca coche
 */
@RequiredArgsConstructor //crea constructor con los atributos Final
@Repository
public class MarcaCocheRepository implements IMarcaCocheRepository {

    /**
     * Crud de marca coche
     */
    private final IMarcaCocheCrudRepository iMarcaCocheCrudRepository;

    /**
     * Mapper de marca coche
     */
    private final IMarcaCocheMapper iMarcaCocheMapper;

    /**
     * Devuelve una lista con todas las marcas de coches
     * @return Lista con marcas de coches
     */
    @Override
    public List<MarcaCocheDto> getAll() {
        return iMarcaCocheMapper.toMarcasCocheDto(iMarcaCocheCrudRepository.findAll());
    }

    /**
     * Devuelve una marca coche dada su id
     * @param id Id de marca coche
     * @return Optional del marca coche encontrado
     */
    @Override
    public Optional<MarcaCocheDto> getMarcaCoche(Integer id) {
        return iMarcaCocheCrudRepository.findById(id)
                .map(iMarcaCocheMapper::toMarcaCocheDto);
//        return iMarcaCocheCrudRepository.findById(id)
//          .map(marcaCocheEntity -> iMarcaCocheMapper.toMarcaCocheDto(marcaCocheEntity));
    }

    /**
     * Guarda una nueva marca coche
     * @param newMarcaCoche Marca coche a guardar
     * @return Marca coche guardada
     */
    @Override
    public MarcaCocheDto save(MarcaCocheDto newMarcaCoche) {
        MarcaCocheEntity marcaCocheEntity = iMarcaCocheMapper.toMarcaCocheEntity(newMarcaCoche);
        return iMarcaCocheMapper.toMarcaCocheDto(iMarcaCocheCrudRepository.save(marcaCocheEntity));

    }

    /**
     * Elimina un marca coche dado un id
     * @param idMarcaCoche Id del marca coche a eliminar
     */
    @Override
    public void delete(Integer idMarcaCoche) {
        iMarcaCocheCrudRepository.deleteById(idMarcaCoche);
    }
}
