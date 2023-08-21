package com.project.coches.persistance.mapper;

import com.project.coches.domain.dto.CompraRequestDto;
import com.project.coches.persistance.entity.CompraEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICompraMapper {


    CompraRequestDto toCompraRequestDto(CompraEntity compraEntity);

    @Mapping(target = "clienteEntity", ignore = true)
    CompraEntity toCompraEntity(CompraRequestDto compraRequestDto);

    List<CompraRequestDto> toComprasRequestDtoList(List<CompraEntity> comprasEntities);
}
