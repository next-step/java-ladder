package nextstep.ladder.controller;

import nextstep.ladder.controller.dto.LadderCreateParam;
import nextstep.ladder.doamin.Ladder;
import nextstep.ladder.doamin.fcatory.LineFactory;
import nextstep.ladder.strategy.LineStrategy;

public class LadderController {
    private final LineStrategy lineStrategy;
    private final LineFactory lineFactory;

    public LadderController(LineStrategy lineStrategy, LineFactory lineFactory) {
        this.lineStrategy = lineStrategy;
        this.lineFactory = lineFactory;
    }

    public Ladder createLadder(LadderCreateParam ladderCreateParam) {
        return Ladder.from(lineFactory.createLines(lineStrategy,
                                                   ladderCreateParam.getCountOfPerson(),
                                                   ladderCreateParam.getHeightOfLadder()));
    }
}
