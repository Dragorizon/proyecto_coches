package com.project.coches.persistance.repository;

import com.project.coches.domain.dto.CocheDto;
import com.project.coches.domain.repository.ICocheRepository;
import com.project.coches.persistance.crud.ICocheCrudRepository;
import com.project.coches.persistance.mapper.ICocheMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class CocheRepository implements ICocheRepository {

    private final ICocheCrudRepository iCocheCrudRepository;

    private final ICocheMapper iCocheMapper;


    @Override
    public List<CocheDto> getAll() {
        return iCocheMapper.toCochesDto(iCocheCrudRepository.findAll());
    }

    @Override
    public List<CocheDto> getByIdMarcaCoche(Integer idMarcaCoche) {
        return iCocheMapper.toCochesDto(iCocheCrudRepository.findAllByMarcaCocheId(idMarcaCoche));
    }

    @Override
    public List<CocheDto> getCochesByPriceLessThan(Double price) {
        return iCocheMapper.toCochesDto(iCocheCrudRepository.findAllByPriceLessThanOrderByPriceDesc(price));
    }

    @Override
    public Optional<CocheDto> getCoche(Integer idCoche) {
        return iCocheCrudRepository.findById(idCoche).map(iCocheMapper :: toCocheDto);
    }

    @Override
    public CocheDto save(CocheDto newCoche) {
        return iCocheMapper.toCocheDto(iCocheCrudRepository.save(iCocheMapper.toCocheEntity(newCoche)));
    }

    @Override
    public void delete(Integer idCoche) {
        iCocheCrudRepository.deleteById(idCoche);
    }
}
