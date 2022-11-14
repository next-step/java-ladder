package laddergame.domain;

import laddergame.util.ManualValueGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:2", "2:0"}, delimiter = ':')
    void 사다리_타기_결과(int start, int end) {
        Ladder ladder = new Ladder(
                new Line(false, true),
                new Line(true, false)
        );
        assertThat(ladder.ride(start)).isEqualTo(end);
    }
}
