package nextstep.inoutladder.domain;

import nextstep.ladder.domain.DirectionEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PointTest {
    @DisplayName("양쪽으로 연결된 잘못된 사다리를 만들경우 예외 발생")
    @Test
    void 잘못된_사다리() {
        assertThatThrownBy(() -> Point.first(true).next(true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("양쪽으로 이어질수 없습니다.");
    }
    @DisplayName("첫 사다리 지점에 연결된 계단이 없다면 현재위치 유지")
    @Test
    void 첫_사다리_현재위치_유지() {
        Point point = Point.first(false);
        assertThat(point.moving()).isEqualTo(DirectionEnum.HOLD_POSITION.getValue());
    }

    @DisplayName("첫 사다리 지점에 연결된 계단이 있다면 오른쪽으로 이동")
    @Test
    void 첫_사다리_이동() {
        Point point = Point.first( true);
        assertThat(point.moving()).isEqualTo(DirectionEnum.GOING_RIGHT.getValue());
    }

    @DisplayName("이전 사다리 지점과 연결된 계단이 있다면 이전으로 이동")
    @Test
    void 사다리_왼쪽_이동() {
        Point point = Point.first( true).next(false);
        assertThat(point.moving()).isEqualTo(DirectionEnum.GOING_LEFT.getValue());
    }

    @DisplayName("다음 사다리 지점과 연결된 계단이 있다면 다음으로 이동")
    @Test
    void 사다리_오른쪽_이동() {
        Point point = Point.first( false).next(true);
        assertThat(point.moving()).isEqualTo(DirectionEnum.GOING_RIGHT.getValue());
    }

    @DisplayName("마지막 사다리 지점에 연결된 계단이 없다면 현재위치 유지")
    @Test
    void 마지막_사다리_현재위치_유지() {
        Point point = Point.first(false).last();
        assertThat(point.moving()).isEqualTo(DirectionEnum.HOLD_POSITION.getValue());
    }

    @DisplayName("마지막 사다리 지점에 연결된 계단이 있다면 왼쪽으로 이동")
    @Test
    void 마지막_사다리_이동() {
        Point point = Point.first( true).last();
        assertThat(point.moving()).isEqualTo(DirectionEnum.GOING_LEFT.getValue());
    }
}