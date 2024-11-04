package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PointTest {

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
    @DisplayName("이전 포인트에 다리가 놓여져 있다면, 다음 포인트에서도 왼쪽에 다리를 놓을 수 있어야 한다.")
    void next() {
        Point point = new Point(false, true);
        Assertions.assertThat(point.next(false)).isEqualTo(new Point(true, false));
    }
}
