package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @DisplayName("방향이 오른쪽이면 위치가 1증가한다.")
    @Test
    void moveRight() {
        Point point = new Point(new Position(0), new Direction(false, true));
        assertThat(point.move()).isEqualTo(new Position(1));
    }

    @DisplayName("방향이 왼쪽이면 위치가 1감소한다.")
    @Test
    void moveLeft() {
        Point point = new Point(new Position(1), new Direction(true, false));
        assertThat(point.move()).isEqualTo(new Position(0));
    }

    @DisplayName("방향이 움직이지 않으면 위치는 그대로다.")
    @Test
    void moveNone() {
        Point point = new Point(new Position(1), new Direction(false, false));
        assertThat(point.move()).isEqualTo(new Position(1));
    }
}
