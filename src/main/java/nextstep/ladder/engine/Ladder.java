package nextstep.ladder.engine;

import java.util.stream.Stream;

import nextstep.ladder.domain.LadderFrame;
import nextstep.ladder.domain.ResultOfGame;

public interface Ladder {
    ResultOfGame resultOfGame(LadderFrame ladderFrame);
    Stream<? extends Line> stream();
}
