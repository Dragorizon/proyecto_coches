package com.project.coches.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "coches_compras")
public class CocheCompraEntity {

    @EmbeddedId
    private CocheCompraPK id;

    @Column(name = "cantidad")
    private Integer cantidad;

    private Integer total;

    @ManyToOne
    @MapsId(value = "compraNumeroFactura")
    @JoinColumn(name = "compras_numero_factura", insertable = false, updatable = false)
    private CompraEntity compraEntity;

    @ManyToOne
    @JoinColumn(name = "coches_codigo_coche", insertable = false, updatable = false)
    private CocheEntity cocheEntity;
}
