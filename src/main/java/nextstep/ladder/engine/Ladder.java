package nextstep.ladder.engine;

import java.util.stream.Stream;

public interface Ladder {
    GameResult result();
    Stream<? extends Line> stream();

    Players players();
    Prizes prizes();
}
