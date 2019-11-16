package com.seok2.ladder.structure.domain;

import com.seok2.ladder.structure.dto.LadderDTO;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LadderAssembler {

    public static LadderDTO assemble(Ladder ladder) {
        return ladder.getLadder().stream()
                .map(LayerAssembler::assemble)
                .collect(collectingAndThen(toList(), LadderDTO::new));
    }

}
