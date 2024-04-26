package nextstep.ladder.domain.rdd;

import nextstep.ladder.domain.Rung;
import nextstep.ladder.interfaces.Ladder;
import nextstep.ladder.interfaces.Line;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameLadderTest {
    @Test
    void game() {
        Rung first = Rung.first(true);
        Rung second = first.next(false);
        Rung last = second.last();

        List<Rung> rungs = List.of(first, second, last);
        GameLineCreator gameLineCreator = new GameLineCreator();
        Line line = gameLineCreator.create(3);

        Ladder ladder = new GameLadderCreator(gameLineCreator).create(3, 3);

    }
}
