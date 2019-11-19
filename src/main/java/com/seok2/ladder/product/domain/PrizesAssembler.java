package com.seok2.ladder.product.domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import com.seok2.ladder.product.dto.PrizesDTO;

public class PrizesAssembler {

    public static PrizesDTO assemble(Prizes prizes) {
        return prizes.stream()
            .map(PrizeAssembler::assemble)
            .collect(collectingAndThen(toList(), PrizesDTO::of));
    }

}
