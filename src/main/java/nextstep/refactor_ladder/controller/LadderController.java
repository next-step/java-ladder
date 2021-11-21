package nextstep.refactor_ladder.controller;

import nextstep.refactor_ladder.controller.dto.LadderCreateParam;
import nextstep.refactor_ladder.domain.Ladder;
import nextstep.refactor_ladder.domain.generate.LineGenerator;
import nextstep.refactor_ladder.strategy.LadderStrategy;

public class LadderController {
    private final LadderStrategy ladderStrategy;

    public LadderController(LadderStrategy ladderStrategy) {
        this.ladderStrategy = ladderStrategy;
    }

    public Ladder createLadder(LadderCreateParam ladderCreateParam) {
        return Ladder.from(LineGenerator.create(ladderCreateParam.getSizeOfPerson(),
                                                ladderCreateParam.getHeightOfLadder(),
                                                ladderStrategy));
    }
}
