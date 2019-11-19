package com.seok2.ladder.structure.domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import com.seok2.ladder.structure.dto.LadderDTO;

public class LadderAssembler {

    public static LadderDTO assemble(Ladder ladder) {
        return ladder.getLadder().stream()
            .map(LayerAssembler::assemble)
            .collect(collectingAndThen(toList(), LadderDTO::new));
    }

}
