package com.seok2.ladder.structure.dto;

import java.util.List;

public class LayerDTO {

    private final List<LineDTO> layer;

    public LayerDTO(List<LineDTO> layer) {
        this.layer = layer;
    }

    public List<LineDTO> getLayer() {
        return layer;
    }
}
