package nextstep.refactoring.laddergame.factory;

import nextstep.refactoring.ladder.engine.Ladder;
import nextstep.refactoring.laddergame.concrete.LadderGameImpl;
import nextstep.refactoring.laddergame.engine.LadderGame;

public class LadderGameFactory {

    private LadderGameFactory() {}

    public static LadderGame ladderGame(Ladder ladder) {
        return new LadderGameImpl(ladder);
    }

}
