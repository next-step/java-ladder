package nextstep.ladder.domain.rdd;

import nextstep.ladder.domain.Rung;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GameLineTest {
    @Test
    void move() {
        Rung first = Rung.first(true);
        Rung second = first.next(false);
        Rung last = second.last();

        List<Rung> rungs = List.of(first, second, last);
        GameLine gameLine = new GameLine(rungs);

        Assertions.assertThat(gameLine.move(0)).isEqualTo(1);
        Assertions.assertThat(gameLine.move(1)).isEqualTo(0);
        Assertions.assertThat(gameLine.move(2)).isEqualTo(2);
    }
}
