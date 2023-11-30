package nextstep.step4.impl;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PointTest {

    @Test
    void last() {
        final Point point = Point.first(false).last();
        assertThat(point.move(1)).isEqualTo(1);
    }
    @Test
    void first() {
        final Point point = Point.first(true);
        assertThat(point.move(1)).isEqualTo(2);
    }

    @Test
    void next() {
        final Point point = Point.first(true).next(false);
        assertThat(point.move(1)).isEqualTo(0);
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
        assertThat(point.move(1)).isEqualTo(0);
    }

    @Test
    void right() {
        final Point point = Point.first(false).next(true);
        assertThat(point.move(1)).isEqualTo(2);
    }
}