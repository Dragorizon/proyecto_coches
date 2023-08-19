package com.project.coches.persistance.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "marca_coche")
public class MarcaCocheEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "descripcion")
    @NotEmpty
    private String description;

    @OneToMany(mappedBy = "marcaCocheEntity", orphanRemoval = true)
    private List<CocheEntity> carroEntities;

}
