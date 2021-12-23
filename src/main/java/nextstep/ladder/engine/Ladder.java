package nextstep.ladder.engine;

import java.util.stream.Stream;

// todo engine에서 domain 보면 안된다.
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.ResultOfGame;
import nextstep.ladder.domain.Prizes;

public interface Ladder {
    ResultOfGame resultOfGame();
    Stream<? extends Line> stream();

    Players players();
    Prizes prizes();
}
