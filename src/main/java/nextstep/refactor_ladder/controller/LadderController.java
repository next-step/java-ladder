package nextstep.refactor_ladder.controller;

import nextstep.refactor_ladder.controller.dto.LadderCreateParam;
import nextstep.refactor_ladder.controller.dto.LadderResultParam;
import nextstep.refactor_ladder.domain.Ladder;
import nextstep.refactor_ladder.domain.LadderResults;
import nextstep.refactor_ladder.domain.generate.LineGenerator;
import nextstep.refactor_ladder.service.LadderService;
import nextstep.refactor_ladder.strategy.LadderStrategy;

public class LadderController {
    private final LadderStrategy ladderStrategy;
    private final LadderService ladderService;

    public LadderController(LadderStrategy ladderStrategy, LadderService ladderService) {
        this.ladderStrategy = ladderStrategy;
        this.ladderService = ladderService;
    }

    public Ladder createLadder(LadderCreateParam ladderCreateParam) {
        return Ladder.from(LineGenerator.create(ladderCreateParam.getSizeOfPerson(),
                                                ladderCreateParam.getHeightOfLadder(),
                                                ladderStrategy));
    }

    public LadderResults getLadderResults(LadderResultParam ladderResultParam) {
        return ladderService.getLadderResults(ladderResultParam.getPeople(), ladderResultParam.getLadder(),
                                              ladderResultParam.getExecutionResults());
    }
}
