package ladder.domain;

import ladder.domain.generator.StubPointGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    @DisplayName("항상 true 발생시 라인 검증")
    void trueLine() {

        Line line = Line.of(5, new StubPointGenerator(true));

        Line expected = new Line(Points.of(Arrays.asList(
                Point.of(0, Direction.RIGHT),
                Point.of(1, Direction.LEFT),
                Point.of(2, Direction.EMPTY),
                Point.of(3, Direction.RIGHT),
                Point.of(4, Direction.LEFT)
        )));

        assertThat(line).isEqualTo(expected);
    }

    @Test
    @DisplayName("항상 false 발생시 라인 검증")
    void falseLine() {

        Line line = Line.of(5, new StubPointGenerator(false));

        Line expected = new Line(Points.of(Arrays.asList(
                Point.of(0, Direction.EMPTY),
                Point.of(1, Direction.EMPTY),
                Point.of(2, Direction.EMPTY),
                Point.of(3, Direction.EMPTY),
                Point.of(4, Direction.EMPTY)
        )));

        assertThat(line).isEqualTo(expected);
    }

}