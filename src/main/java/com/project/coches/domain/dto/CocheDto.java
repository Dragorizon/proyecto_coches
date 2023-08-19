package com.project.coches.domain.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Dto que modela un carro
 */

@Setter @Getter
public class CocheDto {

    private Integer codeCar;

    private Integer marcaCocheId;

    private String reference;

    private Double price;

    private Double yearModel;

    private String color;

    private Double horsepower;

    private Integer numberDoor;

    private Double engineDisplacement;

    private String transmission;

    private String fuelType;

    private Integer numberSeat;

    private Integer traction;

    private String steering;

    private String category;

    private String imagePath;
}
