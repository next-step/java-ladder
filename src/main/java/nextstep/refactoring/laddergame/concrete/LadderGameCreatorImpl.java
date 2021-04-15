package nextstep.refactoring.laddergame.concrete;

import nextstep.refactoring.ladder.engine.Ladder;
import nextstep.refactoring.laddergame.engine.LadderGame;
import nextstep.refactoring.laddergame.engine.LadderGameCreator;

public class LadderGameCreatorImpl implements LadderGameCreator {

    @Override
    public LadderGame create(Ladder ladder) {
        return new LadderGameImpl(ladder);
    }
}
