package ladderinterface.concrete;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @DisplayName("첫번째 점의 위치는 0이고 방향을 가짐")
    @Test
    void first() {
        Point point = Point.first(false);
        assertThat(point).isEqualTo(Point.of(0, Direction.first(false)));
    }

    @DisplayName("다음 점의 위치는 이전 점 + 1")
    @Test
    void next() {
        Point point = Point.first(true).next(false);
        assertThat(point).isEqualTo(Point.of(1, Direction.first(true).next(false)));
    }


    @DisplayName("왼쪽으로 이동시 현재 위치에서 -1 반환")
    @Test
    void move_left() {
        Point point = Point.first(true).next(false);
        assertThat(point.move()).isEqualTo(0);
    }

    @DisplayName("오른쪽으로 이동시 현재 위치에서 +1 반환")
    @Test
    void move_right() {
        Point point = Point.first(false).next(true);
        assertThat(point.move()).isEqualTo(2);
    }

    @DisplayName("아래로 이동시 현재 위치 반환")
    @Test
    void move_down() {
        Point point = Point.first(false).next(false);
        assertThat(point.move()).isEqualTo(1);
    }

}
