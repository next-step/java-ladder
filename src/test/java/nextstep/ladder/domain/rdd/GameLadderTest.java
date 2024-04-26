package nextstep.ladder.domain.rdd;

import nextstep.ladder.domain.Rung;
import nextstep.ladder.interfaces.Ladder;
import nextstep.ladder.interfaces.Line;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GameLadderTest {
    @Test
    void game() {
        Rung first = Rung.first(true);
        Rung second = first.next(false);
        Rung last = second.last();

        List<Rung> rungs = List.of(first, second, last);

        Line line = new GameLine(rungs);
        Ladder ladder = new GameLadder(1, List.of(line));
        ladder.game();
    }
}
