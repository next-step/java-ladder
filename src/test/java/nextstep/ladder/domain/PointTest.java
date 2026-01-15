package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class PointTest {

    @Test
    void first_오른쪽연결있음() {
        Point point = Point.first(true);
        assertThat(point.hasRightConnection()).isTrue();
        assertThat(point.move()).isEqualTo(Direction.RIGHT);
    }

    @Test
    void first_오른쪽연결없음() {
        Point point = Point.first(false);
        assertThat(point.hasRightConnection()).isFalse();
        assertThat(point.move()).isEqualTo(Direction.DOWN);
    }

    @Test
    void next_이전오른쪽연결시_왼쪽이동() {
        Point first = Point.first(true);
        Point second = first.next(false);
        assertThat(second.move()).isEqualTo(Direction.LEFT);
    }

    @Test
    void next_이전연결없고_현재오른쪽연결() {
        Point first = Point.first(false);
        Point second = first.next(true);
        assertThat(second.move()).isEqualTo(Direction.RIGHT);
    }

    @Test
    void next_연속된가로선_예외() {
        Point first = Point.first(true);
        assertThatThrownBy(() -> first.next(true))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("연속된 가로선은 허용되지 않습니다.");
    }

    @Test
    void last_이전오른쪽연결시_왼쪽이동() {
        Point first = Point.first(true);
        Point last = first.last();
        assertThat(last.move()).isEqualTo(Direction.LEFT);
    }

    @Test
    void last_이전연결없으면_아래로() {
        Point first = Point.first(false);
        Point last = first.last();
        assertThat(last.move()).isEqualTo(Direction.DOWN);
    }
}