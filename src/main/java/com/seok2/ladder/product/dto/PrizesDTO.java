package com.seok2.ladder.product.dto;

import java.util.Collections;
import java.util.List;

public class PrizesDTO {

    private final List<PrizeDTO> prizesDTO;

    private PrizesDTO(List<PrizeDTO> prizesDTO) {
        this.prizesDTO = Collections.unmodifiableList(prizesDTO);
    }

    public static PrizesDTO of(List<PrizeDTO> prizesDTO) {
        return new PrizesDTO(prizesDTO);
    }

    public List<PrizeDTO> getPrizesDTO() {
        return prizesDTO;
    }
}
