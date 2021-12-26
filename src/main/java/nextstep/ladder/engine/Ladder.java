package nextstep.ladder.engine;

import java.util.stream.Stream;

public interface Ladder extends LadderRails, LadderFrame {
    GameResult move(Prizes prizes);
    Stream<? extends Line> stream();
}
