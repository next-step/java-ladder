package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PointTest {

    @Test
    void 포인트_생성() {
        Point point = new Point();
        assertThat(point).isEqualTo(new Point());
    }

    @Test
    void moveDown() {
        Point point = new Point(false, false);
        Assertions.assertThat(point.move()).isEqualTo(Direction.DOWN);
    }

    @Test
    void moveLeft() {
        Point point = new Point(true, false);
        Assertions.assertThat(point.move()).isEqualTo(Direction.LEFT);
    }

    @Test
    void moveRight() {
        Point point = new Point(false, true);
        Assertions.assertThat(point.move()).isEqualTo(Direction.RIGHT);
    }

    @Test
    void invalidMove() {
        assertThatThrownBy(() -> {
            Point point = new Point(true, true);
            point.move();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void first() {
        Point point = Point.first(false);
        Assertions.assertThat(point.move()).isEqualTo(Direction.DOWN);
    }

    @Test
    void next() {
        Point point = new Point(false, true);
        Assertions.assertThat(point.next(false)).isEqualTo(new Point(true, false));
    }
}
