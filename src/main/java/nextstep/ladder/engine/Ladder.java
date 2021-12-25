package nextstep.ladder.engine;

import java.util.stream.Stream;

public interface Ladder extends LadderRails {
    GameResult move(Prizes prizes);
    Stream<? extends Line> stream();
}
