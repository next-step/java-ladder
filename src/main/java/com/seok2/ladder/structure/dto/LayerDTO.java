package com.seok2.ladder.structure.dto;

import java.util.Collections;
import java.util.List;

public class LayerDTO {

    private final List<PillarDTO> layer;

    public LayerDTO(List<PillarDTO> layer) {
        this.layer = Collections.unmodifiableList(layer);
    }

    public List<PillarDTO> getLayer() {
        return layer;
    }
}
