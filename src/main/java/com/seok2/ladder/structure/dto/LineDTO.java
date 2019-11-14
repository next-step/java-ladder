package com.seok2.ladder.structure.dto;

public class LineDTO {

    private final boolean rung;

    public LineDTO(boolean rung) {
        this.rung = rung;
    }

    public boolean getRung() {
        return rung;
    }
}
