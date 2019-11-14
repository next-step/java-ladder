package com.seok2.ladder.structure.dto;

import com.seok2.ladder.structure.domain.Rung;

public class LineDTO {

    private final Rung rung;

    public LineDTO(Rung rung) {
        this.rung = rung;
    }

    public Rung getRung() {
        return rung;
    }
}
