package ladder.domain.ladder.point;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PointTest {

    @Test
    void permute_left() {
        Point point = Point.of(3, Leg.of(true, false));
        assertThat(point.permute()).isEqualTo(2);
    }

    @Test
    void permute_right() {
        Point point = Point.of(3, Leg.of(false, true));
        assertThat(point.permute()).isEqualTo(4);
    }

    @Test
    void permute_down() {
        Point point = Point.of(3, Leg.of(false, false));
        assertThat(point.permute()).isEqualTo(3);
    }

    @Test
    void first() {
        Point point = Point.first(true);
        assertThat(point.permute()).isEqualTo(1);
    }

    @Test
    void next_left() {
        Point point = Point.first(true).next(false);
        assertThat(point.permute()).isZero();
    }

    @Test
    void next_right() {
        Point point = Point.first(false).next(true);
        assertThat(point.permute()).isEqualTo(2);
    }

    @Test
    void last() {
        Point point = Point.first(true).last();
        assertThat(point.permute()).isZero();
    }
}