package com.seok2.ladder.game.domain;

import static java.util.stream.Collectors.collectingAndThen;

import com.seok2.ladder.game.dto.ResultDTO;
import java.util.stream.Collectors;

public class ResultAssembler {

    private ResultAssembler() {
    }

    public static ResultDTO assemble(Result result) {
        return result.getResult().entrySet().stream()
            .collect(collectingAndThen(Collectors.toMap(
                e -> e.getKey().getParticipant().getName(),
                e -> e.getValue().getPrize().getName()
            ), ResultDTO::of));
    }
}
