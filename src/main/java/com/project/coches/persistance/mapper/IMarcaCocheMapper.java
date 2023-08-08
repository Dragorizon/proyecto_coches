package com.project.coches.persistance.mapper;

import com.project.coches.domain.dto.MarcaCocheDto;
import com.project.coches.persistance.entity.MarcaCocheEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper que transforma objetos de MarcaCoche a dto o entidades
 */
@Mapper(componentModel = "spring")
public interface IMarcaCocheMapper {

    /**
     * convierte una entidad a un dto de marca coche
     * @param marcaEntity entidad a convertir
     * @return dto convertido
     */
    @Mapping(source = "id", target = "id")
    //cuando el source y el target se llaman de la misma manera no es necesario agregar el @Mapping
    //implicitamente el mapper lo reconoce
    @Mapping(source = "description", target = "description")
    MarcaCocheDto toMarcaCocheDto(MarcaCocheEntity marcaEntity);


    /**
     * convierte un dto a una entidad de marca coche
     * @param marcaDto entidad a convertir
     * @return  entity convertido
     */
    @InheritInverseConfiguration
    MarcaCocheEntity toMarcaCocheEntity(MarcaCocheDto marcaDto);

    /**
     * Retorna una lista de marcas coche transformada a dto de una lista de entidades
     * @param marcasCocheEntity Entidad a transformar
     * @return Lista transformada
     */
    List<MarcaCocheDto> toMarcaCocheDto(List<MarcaCocheEntity> marcasCocheEntity);
}
