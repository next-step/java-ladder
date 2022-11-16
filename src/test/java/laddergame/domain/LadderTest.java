package laddergame.domain;

import laddergame.util.ManualValueGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    void 생성() {
        Ladder ladder = Ladder.create(2, 2, new ManualValueGenerator(true, true));
        assertThat(ladder).isEqualTo(Ladder.of(
                Line.of(new Point(0, false, true), new Point(1, true, false)),
                Line.of(new Point(0, false, true), new Point(1, true, false))));
    }

    @Test
    void 이동() {
        Ladder ladder = Ladder.of(
                Line.of(new Point(0, false, true), new Point(1, true, false)),
                Line.of(new Point(0, false, true), new Point(1, true, false))
        );
        assertThat(ladder.ride(0)).isEqualTo(0);
        assertThat(ladder.ride(1)).isEqualTo(1);
    }
}
