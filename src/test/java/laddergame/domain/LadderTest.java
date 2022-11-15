package laddergame.domain;

import laddergame.util.ManualValueGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    void 사다리_생성() {
        assertThat(Ladder.create(new Height(2), new Width(2),
                new ManualValueGenerator(true, false, false, true)))
                .isEqualTo(new Ladder(
                        new Line(true, false),
                        new Line(false, true))
                );
    }
}
