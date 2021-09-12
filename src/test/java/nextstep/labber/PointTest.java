package nextstep.labber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PointTest {
    @Test
    @DisplayName("이전값과 현재값이 둘다 참일경우")
    void create() {
        assertThatThrownBy(() -> {
            Point point = Point.first(true).next(true);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("첫번째 prev 값은 false")
    void first() {
        Point point = Point.first(false);
        assertThat(point.move()).isEqualTo(Compass.DOWN);
    }

    @Test
    @DisplayName("오른쪽으로 이동")
    void move_right() {
        Point point = Point.first(false).next(true).next(false).next(true);
        assertThat(point.move()).isEqualTo(Compass.RIGHT);
    }

    @Test
    @DisplayName("왼쪽으로 이동")
    void move_left() {
        Point point = Point.first(true).next(false);
        assertThat(point.move()).isEqualTo(Compass.LEFT);
    }

    @Test
    @DisplayName("이전값이 참이면 다음은 거짓")
    void next() {
        Point point = Point.first(true).next();
        assertThat(point.move()).isEqualTo(Compass.LEFT);
    }
}