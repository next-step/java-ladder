package nextstep.ladder;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    void ladder() {
        Rung first = Rung.first(true);
        Rung second = first.next(false);
        Rung last = second.last();

        List<Rung> rungs = List.of(first, second, last);
        Line line = new Line(3, rungs);

        Ladder ladder = new Ladder(1, List.of(line));

        assertThat(ladder.move(0)).isEqualTo(1);
        assertThat(ladder.move(1)).isEqualTo(0);
        assertThat(ladder.move(2)).isEqualTo(2);
    }

    @Test
    void create() {
        int height = 3;
        Ladder ladder = new Ladder(height).create(height, 3);

    }
}
