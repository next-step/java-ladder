package ladder.engine;

import ladder.domain.Players;

public interface LadderResult {
    Players result(Players players, LadderCreator ladderCreator);
}
