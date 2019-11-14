package com.seok2.ladder.product.dto;

public class PrizeDTO {

    private final String name;

    private PrizeDTO(String name) {
        this.name = name;
    }

    public static PrizeDTO of(String name) {
        return new PrizeDTO(name);
    }

    public String getName() {
        return name;
    }
}
