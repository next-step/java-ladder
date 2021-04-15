package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    void create() {
        assertThatCode(() -> Line.of(5, new RandomBooleanStrategy())).doesNotThrowAnyException();
    }

    @Test
    void nextHorizontalNumber() {
        Line line = Line.of(Arrays.asList(Point.of(true), Point.of(false), Point.of(true), Point.of(false)));

        assertThat(line.nextHorizontalNumber(0)).isEqualTo(1);
        assertThat(line.nextHorizontalNumber(1)).isEqualTo(0);
        assertThat(line.nextHorizontalNumber(2)).isEqualTo(3);
        assertThat(line.nextHorizontalNumber(3)).isEqualTo(2);
        assertThat(line.nextHorizontalNumber(4)).isEqualTo(4);

        line = Line.of(Arrays.asList(Point.of(false), Point.of(true), Point.of(false), Point.of(true)));

        assertThat(line.nextHorizontalNumber(0)).isEqualTo(0);
        assertThat(line.nextHorizontalNumber(1)).isEqualTo(2);
        assertThat(line.nextHorizontalNumber(2)).isEqualTo(1);
        assertThat(line.nextHorizontalNumber(3)).isEqualTo(4);
        assertThat(line.nextHorizontalNumber(4)).isEqualTo(3);
    }
}
