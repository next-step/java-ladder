package nextstep.ladder.domain.rdd;

import nextstep.ladder.domain.Rung;
import nextstep.ladder.interfaces.Ladder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GameLadderTest {
    @Test
    void game() {
        Rung first = Rung.first(true);
        Rung second = first.next(false);
        Rung last = second.last();

        GameLine firstLine = new GameLine(List.of(first, second, last));
        GameLine secondLine = new GameLine(List.of(first, second, last));
        GameLine LastLine = new GameLine(List.of(first, second, last));

        Ladder ladder = new GameLadder(3, List.of(firstLine, secondLine, LastLine));

        Assertions.assertThat(ladder.game().findResult(0)).isEqualTo(1);
        Assertions.assertThat(ladder.game().findResult(1)).isEqualTo(0);
        Assertions.assertThat(ladder.game().findResult(2)).isEqualTo(2);
    }
}
