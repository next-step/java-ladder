package nextstep.laddergame.engine;

import nextstep.laddergame.engine.strategy.LineStrategy;

public interface LadderCreator {

  Ladder createLadder(LineStrategy lineStrategy);
}
