package com.project.coches.persistance.mapper;

import com.project.coches.domain.dto.CocheDto;
import com.project.coches.persistance.entity.CocheEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICocheMapper {

    CocheDto toCocheDto(CocheEntity cocheEntity);

    @Mapping(target = "marcaCocheEntity", ignore = true) //se ignora el atributo de la relacion entre coche y marcaCoche
    CocheEntity toCocheEntity(CocheDto cocheDto);


    List<CocheDto> toCochesDto(List<CocheEntity> cocheEntityList);
}
