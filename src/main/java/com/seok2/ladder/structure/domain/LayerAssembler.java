package com.seok2.ladder.structure.domain;

import com.seok2.ladder.structure.dto.LayerDTO;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;


public class LayerAssembler {

    static LayerDTO assemble(Layer layer) {
        return layer.getLayer().stream()
                .map(PillarAssembler::assemble)
                .collect(collectingAndThen(toList(), LayerDTO::new));
    }
}
