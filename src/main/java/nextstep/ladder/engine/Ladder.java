package nextstep.ladder.engine;

import java.util.stream.Stream;

public interface Ladder {
    GameResult move(Prizes prizes);
    Stream<? extends Line> stream();

    Players players();
    Prizes prizes();
}
