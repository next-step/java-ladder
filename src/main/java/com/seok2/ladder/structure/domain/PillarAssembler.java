package com.seok2.ladder.structure.domain;


import com.seok2.ladder.structure.dto.PillarDTO;
import java.util.Optional;

public class PillarAssembler {

    private PillarAssembler() {
    }

    static PillarDTO assemble(Pillar pillar) {
        return new PillarDTO(Optional.ofNullable(pillar.getRung()).map(Rung::isRight).orElse(false));
    }
}
