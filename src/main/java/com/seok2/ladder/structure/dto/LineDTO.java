package com.seok2.ladder.structure.dto;

import com.seok2.ladder.structure.domain.Rung;

public class LineDTO {

    private final boolean rung;

    public LineDTO(boolean rung) {
        this.rung = rung;
    }

    public boolean getRung() {
        return rung;
    }
}
