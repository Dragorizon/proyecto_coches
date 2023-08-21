package com.project.coches.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@Entity
@Table(name = "compras")
public class CompraEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_factura")
    private Integer numberBill;

    @Column(name = "clienteCI")
    private String carnetIdCliente;

    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime date;

    private Double total;

    @Column(name = "medio_pago")
    private String paymentMethod;

    @ManyToOne
    @JoinColumn(name = "clienteCI", insertable = false, updatable = false)
    private ClienteEntity clienteEntity;

    @OneToMany(mappedBy = "compraEntity", cascade = CascadeType.ALL)
    private List<CocheCompraEntity> cocheCompras;
}
