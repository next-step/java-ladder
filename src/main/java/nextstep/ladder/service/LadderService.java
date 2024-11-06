package nextstep.ladder.service;

import nextstep.ladder.engine.LadderGame;
import nextstep.ladder.vo.Result;

public class LadderService {
    private final LadderGame ladderGame;

    public LadderService(final LadderGame ladderGame) {
        this.ladderGame = ladderGame;
    }

    public Result play(final String names, final String executeResult, final int countLadderHeight) {
        return ladderGame.play(names, executeResult, countLadderHeight);
    }
}
