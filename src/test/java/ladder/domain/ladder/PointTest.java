package ladder.domain.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PointTest {

    @Test
    void move_center() {
        Point point = Point.first(false);
        Assertions.assertThat(point.move()).isEqualTo(0);
    }

    @Test
    void move_left() {
        Point point = Point.first(true).next(false);
        Assertions.assertThat(point.move()).isEqualTo(0);
    }

    @Test
    void move_right() {
        Point point = Point.first(false).next(true);
        Assertions.assertThat(point.move()).isEqualTo(2);
    }

    @Test
    void move_last() {
        Point point = Point.first(false).last();
        Assertions.assertThat(point.move()).isEqualTo(1);
    }

    @Test
    void getDirection() {
        Assertions.assertThat(Point.first(false).getDirection())
                .isEqualTo(Direction.of(false, false));
    }
}
