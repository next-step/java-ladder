package com.seok2.ladder.structure.dto;

public class LineDTO {

    private final boolean rung;

    public LineDTO(boolean lung) {
        this.rung = lung;
    }

    public boolean isRung() {
        return rung;
    }
}
