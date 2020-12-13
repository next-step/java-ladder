package nextstep.step4.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    @DisplayName("첫번째 포인트는 false")
    void setFirstFalse() {
        Point point = Point.setFirst((boolean previous) -> true);
        assertThat(point.move()).isEqualTo(Direction.RIGHT);
    }

    @Test
    @DisplayName("왼쪽 이동")
    void setNextFalse() {
        Point point = Point.setFirst((boolean previous) -> true).setNext((boolean previous) -> false);
        assertThat(point.move()).isEqualTo(Direction.LEFT);
    }

    @Test
    @DisplayName("오른쪽 이동")
    void moveRight() {
        Point point = Point.setFirst((boolean previous) -> false).setNext((boolean previous) -> true);
        assertThat(point.move()).isEqualTo(Direction.RIGHT);
    }

    @Test
    @DisplayName("직진 이동")
    void moveForward() {
        Point point = Point.setFirst((boolean previous) -> false).setNext((boolean previous) -> false);
        assertThat(point.move()).isEqualTo(Direction.FORWARD);
    }

    @Test
    @DisplayName("마지막 인덱스는 false")
    void setLast() {
        Point point = Point.setFirst((boolean previous) -> true).setNext((boolean previous) -> false).setLast();
        assertThat(point.move()).isEqualTo(Direction.FORWARD);
    }

    @Test
    @DisplayName("이전 방향이 오른쪽인데 현재 방향도 오른쪽일 경우 예외처리")
    void doubleTrueException() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Point.setFirst((boolean previous) -> true).setNext((boolean previous) -> true));
    }

}