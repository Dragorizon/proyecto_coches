package com.project.coches.persistance.mapper;

import com.project.coches.domain.dto.ClienteDto;
import com.project.coches.persistance.entity.ClienteEntity;
import com.project.coches.persistance.entity.MarcaCocheEntity;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * mapper del cliente
 */
@Mapper(componentModel = "spring")
public interface IClienteMapper {

    /**
     * convierte una entidad a un dto de cliente
     * @param clienteEntity entidad a convertir
     * @return dto convertido
     */
    ClienteDto toClienteDto(ClienteEntity clienteEntity);

    /**
     * convierte un dto a un entity de cliente
     * @param clienteDto dto a convertir
     * @return entity convertido
     */
    ClienteEntity toClienteEntity(ClienteDto clienteDto);

    /**
     * retorna una lista de clientes transformada a dto de una lista de entidades
     * @param clientesEntityList entidad a transformar
     * @return lista transformada
     */
    List<ClienteDto> toClientesDto(List<ClienteEntity> clientesEntityList);
}
