package com.project.coches.domain.dto;

import java.time.LocalDateTime;
import java.util.List;

public class CompraRequestDto {

    private Integer numberBill;

    private String carnetIdCliente;

    private LocalDateTime date;

    private Double total;

    private String paymentMethod;

    private List<CocheCompraRequestDto> cocheCompras;
}
