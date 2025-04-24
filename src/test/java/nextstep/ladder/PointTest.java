package nextstep.ladder;

import ladder.Point;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PointTest {

    @Test
    void first() {
        Assertions.assertThat(Point.first(true).move()).isEqualTo(Direction.RIGHT);
    }

    @Test
    void last() {
        Point point = Point.first(true).next(false).last();
        Assertions.assertThat(point.move()).isEqualTo(Direction.SOUTH);
    }

    @Test
    void next() {
        Point point = Point.first(true).next(false);
        Assertions.assertThat(point.move()).isEqualTo(Direction.LEFT);
    }

    @Test
    void invalid() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Point.first(true).next(true));
    }

    @Test
    void left() {
        Point point = Point.first(true).next(false);
        Assertions.assertThat(point.move()).isEqualTo(Direction.LEFT);
    }

    @Test
    void right() {
        Point point = Point.first(false).next(true);
        Assertions.assertThat(point.move()).isEqualTo(Direction.RIGHT);
    }

    @Test
    void pass() {
        Point point = Point.first(false).next(false);
        Assertions.assertThat(point.move()).isEqualTo(Direction.SOUTH);
    }
}
