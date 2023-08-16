package com.project.coches.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ClienteDto {

    private String carnetId;

    private String nombre;

    private String email;

    private Double telefono;

    private Integer activo;

    private String password;


}
