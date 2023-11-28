package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PointTest {

    @Test
    void last() {
        final Point point = Point.first(false).last();
        assertThat(point.move()).isEqualTo(Direction.PASS);
    }
    @Test
    void first() {
        final Point point = Point.first(true);
        assertThat(point.move()).isEqualTo(Direction.RIGHT);
    }

    @Test
    void next() {
        final Point point = Point.first(true).next(false);
        assertThat(point.move()).isEqualTo(Direction.LEFT);
    }

    @Test
    void invalid() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            assertThat(Point.first(true).next(true));
        });
    }

    @Test
    void left() {
        final Point point = Point.first(true).next(false);
        assertThat(point.move()).isEqualTo(Direction.LEFT);
    }

    @Test
    void right() {
        final Point point = Point.first(false).next(true);
        assertThat(point.move()).isEqualTo(Direction.RIGHT);
    }
}