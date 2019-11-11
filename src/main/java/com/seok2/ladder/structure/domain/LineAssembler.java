package com.seok2.ladder.structure.domain;


import com.seok2.ladder.structure.dto.LineDTO;

public class LineAssembler {

    static LineDTO assemble(Line line) {
        return new LineDTO(line.rung);
    }
}
