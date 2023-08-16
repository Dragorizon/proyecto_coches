package com.project.coches.domain.service;

import com.project.coches.domain.dto.ClienteDto;
import com.project.coches.domain.dto.MarcaCocheDto;
import com.project.coches.domain.dto.ResponseClienteDto;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz de servicio de cliente
 */
public interface IClienteService {

    /**
     * Devuelve una lista de todos las clientes
     * @return Lista de clientes
     */
    List<ClienteDto> getAll();

    /**
     * Devuelve una cliente dada su id
     * @param carnetId Id de cliente
     * @return Optional del cliente encontrado
     */
    Optional<ClienteDto> getClienteByCarnetId(String carnetId);

    /**
     * Devuelve una cliente dada su id
     * @param email Id de cliente
     * @return Optional del cliente encontrado
     */
    Optional<ClienteDto> getClienteByEmail(String email);

    /**
     * Guarda una nuevo cliente
     * @param newCliente cliente a guardar
     * @return cliente guardado
     */
    ResponseClienteDto save(ClienteDto newCliente);

    Optional<ClienteDto> update(ClienteDto modifyCliente);

    /**
     * Elimina un cliente dado si carnetId
     * @param carnetID carnetId del cliente a eliminar
     */
    boolean delete(String carnetID);
}
