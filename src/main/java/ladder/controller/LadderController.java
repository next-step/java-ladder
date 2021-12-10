package ladder.controller;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderHeight;
import ladder.domain.user.Players;
import ladder.strategy.LineStrategy;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    private final LineStrategy lineStrategy;

    public LadderController(LineStrategy lineStrategy) {
        this.lineStrategy = lineStrategy;
    }

    public Ladder createLadder(Players players, LadderHeight height) {
        return Ladder.createLadder(lineStrategy, players, height);
    }

}
