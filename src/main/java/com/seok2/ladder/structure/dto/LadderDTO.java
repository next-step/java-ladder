package com.seok2.ladder.structure.dto;

import com.seok2.ladder.user.dto.ParticipantDTO;
import java.util.List;

public class LadderDTO {

    private final List<LayerDTO> layers;

    public LadderDTO(List<LayerDTO> layers) {
        this.layers = layers;
    }

    public List<LayerDTO> getLayers() {
        return layers;
    }
}
