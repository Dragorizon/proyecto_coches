package com.project.coches.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entidad de un cliente
 */
@Getter
@Setter
@Entity
@Table(name = "cliente")
public class ClienteEntity {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CI")
    private String carnetId;

    @Column(name = "nombre_completo")
    private String nombre;

    @Column(name = "correo")
    private String email;

    @Column(name = "celular")
    private Double telefono;

    @Column(name = "activo")
    private Integer activo;

    @Column(name = "contraseña")
    private String password;
}
