package com.project.coches.persistance.repository;

import com.project.coches.domain.dto.ClienteDto;
import com.project.coches.domain.repository.IClienteRepository;
import com.project.coches.persistance.entity.ClienteEntity;
import com.project.coches.persistance.entity.MarcaCocheEntity;
import com.project.coches.persistance.mapper.IClienteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class ClienteRepository implements IClienteRepository {

    private final IClienteCrudRepository iClienteCrudRepository;

    private final IClienteMapper iClienteMapper;


    @Override
    public List<ClienteDto> getAll() {
        return iClienteMapper.toClientesDto(iClienteCrudRepository.findAll());
    }

    @Override
    public Optional<ClienteDto> getClienteByCarnetId(String carnetId) {
        return iClienteCrudRepository.findById(carnetId).map(iClienteMapper :: toClienteDto);
    }

    @Override
    public Optional<ClienteDto> getClienteByEmail(String email) {
        return iClienteCrudRepository.findByEmail(email).map(iClienteMapper :: toClienteDto);
    }

    @Override
    public ClienteDto save(ClienteDto newCliente) {
        ClienteEntity clienteEntity = iClienteMapper.toClienteEntity(newCliente);
        return iClienteMapper.toClienteDto(iClienteCrudRepository.save(clienteEntity));
    }

    @Override
    public void delete(String carnetID) {
        iClienteCrudRepository.deleteById(carnetID);
    }
}
