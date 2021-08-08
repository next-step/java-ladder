package nextstep.ladder.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @DisplayName("시작 지점 좌표가 true 이면 위치값이 1이고 false 이면 0이다.")
    @Test
    void first() {
        assertThat(Point.first(TRUE).move()).isEqualTo(1);
        assertThat(Point.first(FALSE).move()).isZero();
    }


    @DisplayName("시작 지점 좌표가 false 이고 다음 좌표가 false 이면 움직이지 않는다.")
    @Test
    void next_stay() {
        Point second = Point.first(FALSE).next(FALSE);
        assertThat(second.move()).isEqualTo(1);
    }

    @DisplayName("시작 지점 좌표가 true 이고 다음 좌표가 false 이면 위치값이 감소한다.")
    @Test
    void next_left() {
        Point second = Point.first(TRUE).next(FALSE);
        assertThat(second.move()).isZero();
    }

    @DisplayName("시작 지점 좌표가 false 이고 다음 좌표가 true 이면 위치값이 증가한다.")
    @Test
    void next_right() {
        Point second = Point.first(FALSE).next(TRUE);
        assertThat(second.move()).isEqualTo(2);
    }

    @DisplayName("시작 지점 좌표가 true 이면 다음 포지션은 왼쪽으로 이동해서 1 감소한다.")
    @Test
    void next() {
        Point second = Point.first(TRUE).next();
        assertThat(second.move()).isZero();
    }
}