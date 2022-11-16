package laddergame.domain.ladder;

import laddergame.util.ManualValueGenerator;
import laddergame.util.ValueGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    void 생성() {
        ValueGenerator generator = new ManualValueGenerator(true, false, false);
        assertThat(Line.create(3, generator)).isEqualTo(
                Line.of(new Point(0, false, true),
                        new Point(1, true, false),
                        new Point(2, false, false)));
    }

    @Test
    void 생성_연달아_true_값_존재() {
        ValueGenerator generator = new ManualValueGenerator(true, true, false);
        assertThat(Line.create(3, generator)).isEqualTo(
                Line.of(new Point(0, false, true),
                        new Point(1, true, false),
                        new Point(2, false, false)));
    }

    @Test
    void 이동() {
        Line line = Line.of(new Point(0, false, true),
                new Point(1, true, false),
                new Point(2, false, false));
        assertThat(line.move(0)).isEqualTo(1);
        assertThat(line.move(1)).isEqualTo(0);
        assertThat(line.move(2)).isEqualTo(2);
    }
}
