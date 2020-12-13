package nextstep.step4.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    @DisplayName("오른쪽 이동")
    void moveRight() {
        Point point = new Point(false, true);
        assertThat(point.move()).isEqualTo(Direction.RIGHT);
    }

    @Test
    @DisplayName("직진 이동")
    void moveForward() {
        Point point = new Point(false, false);
        assertThat(point.move()).isEqualTo(Direction.FORWARD);
    }

    @Test
    @DisplayName("왼쪽 이동")
    void moveLeft() {
        Point point = new Point(true, false);
        assertThat(point.move()).isEqualTo(Direction.LEFT);
    }

    @Test
    @DisplayName("이전 방향이 오른쪽인데 현재 방향도 오른쪽일 경우 예외처리")
    void doubleTrueException() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Point(true, true));
    }

}