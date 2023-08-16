package com.project.coches.domain.service;

import com.project.coches.domain.dto.ClienteDto;
import com.project.coches.domain.dto.ResponseClienteDto;
import com.project.coches.domain.repository.IClienteRepository;
import com.project.coches.persistance.repository.IClienteCrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClienteService implements IClienteService {

    private final IClienteRepository iClienteRepository;

    @Override
    public List<ClienteDto> getAll() {
        return iClienteRepository.getAll();
    }

    @Override
    public Optional<ClienteDto> getClienteByCarnetId(String carnetId) {
        return iClienteRepository.getClienteByCarnetId(carnetId);
    }

    @Override
    public Optional<ClienteDto> getClienteByEmail(String email) {
        return iClienteRepository.getClienteByEmail(email);
    }

    @Override
    public ResponseClienteDto save(ClienteDto newCliente) {

        String passwordGenerated = generateRandomPassword(8);
        newCliente.setPassword(passwordGenerated);
        newCliente.setActivo(1);
        iClienteRepository.save(newCliente);

        return new ResponseClienteDto(passwordGenerated);

    }

    @Override
    public Optional<ClienteDto> update(ClienteDto modifyCliente) {
        if(iClienteRepository.getClienteByCarnetId(modifyCliente.getCarnetId()).isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(iClienteRepository.save(modifyCliente)) ;
    }

    @Override
    public boolean delete(String carnetID) {
        if(iClienteRepository.getClienteByCarnetId(carnetID).isEmpty()) {
            return false;
        }
        iClienteRepository.delete(carnetID);
        return true;
    }


    private String generateRandomPassword(int len){

        //Rango ASCII - alfanumerico (0-9, a-z, A-Z)
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        //Cada iteracion del bucle elige aleatoriamente un caracter del dado
        //rango ASCII y lo agreg a la instancia `StringBuilder`

        for(int i = 0; i < len; i++){
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }

        return sb.toString();
    }
}
