package com.project.coches.domain.service;

import com.project.coches.domain.dto.CocheDto;
import com.project.coches.domain.repository.ICocheRepository;
import com.project.coches.domain.useCase.ICocheService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CocheService implements ICocheService {

    private final ICocheRepository iCocheRepository;


    @Override
    public List<CocheDto> getAll() {
        return iCocheRepository.getAll();
    }

    @Override
    public List<CocheDto> getByIdMarcaCoche(Integer idMarcaCoche) {
        return iCocheRepository.getByIdMarcaCoche(idMarcaCoche);
    }

    @Override
    public List<CocheDto> getCochesByPriceLessThan(Double price) {
        return iCocheRepository.getCochesByPriceLessThan(price);
    }

    @Override
    public Optional<CocheDto> getCoche(Integer idCoche) {
        return iCocheRepository.getCoche(idCoche);
    }

    @Override
    public CocheDto save(CocheDto newCoche) {
        return iCocheRepository.save(newCoche);
    }

    @Override
    public Optional<CocheDto> update(CocheDto modifyCoche) {
        if(iCocheRepository.getCoche(modifyCoche.getCodeCar()).isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(iCocheRepository.save(modifyCoche)) ;
    }

    @Override
    public Boolean delete(Integer idCoche) {
        if(iCocheRepository.getCoche(idCoche).isEmpty()) {
            return false;
        }
        iCocheRepository.delete(idCoche);
        return true;
    }
}
