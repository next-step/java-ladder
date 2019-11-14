package com.seok2.ladder.structure.domain;


import com.seok2.ladder.structure.dto.LineDTO;

import java.util.Optional;

public class LineAssembler {

    static LineDTO assemble(Pillar pillar) {
        return new LineDTO(Optional.ofNullable(pillar.getRung()).map(Rung::isRight).orElse(false));
    }
}
