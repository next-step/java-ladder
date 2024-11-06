package nextstep.ladder.engine;

import nextstep.ladder.vo.Result;

public interface LadderGame {
    Result play(final String names, final String executeResult, final int countLadderHeight);
}
