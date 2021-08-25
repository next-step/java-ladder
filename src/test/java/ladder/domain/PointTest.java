package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {
    @Test
    public void first() {
        assertThat(Point.first(true).movedIndex()).isEqualTo(1);
        assertThat(Point.first(false).movedIndex()).isEqualTo(0);
    }

    @Test
    public void next_stay() {
        Point second = Point.first(false).next(false);
        assertThat(second.movedIndex()).isEqualTo(1);
    }

    @Test
    public void next_left() {
        Point second = Point.first(true).next(false);
        assertThat(second.movedIndex()).isEqualTo(0);
    }

    @Test
    public void next_right() {
        Point second = Point.first(false).next(true);
        assertThat(second.movedIndex()).isEqualTo(2);
    }

    @Test
    public void next() {
        Point second = Point.first(true).next();
        assertThat(second.movedIndex()).isEqualTo(0);
    }
}