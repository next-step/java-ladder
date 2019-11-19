package com.seok2.ladder.product.domain;

import com.seok2.ladder.product.dto.PrizeDTO;

public class PrizeAssembler {

    private PrizeAssembler() {
    }

    static PrizeDTO assemble(Prize prize) {
        return PrizeDTO.of(prize.getName());
    }

}
