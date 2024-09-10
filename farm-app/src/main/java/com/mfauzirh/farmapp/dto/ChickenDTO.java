package com.mfauzirh.farmapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChickenDTO {
    private String name;
    private int eggCount;
    private double pricePerEgg;
}