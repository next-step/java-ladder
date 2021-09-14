package step4.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.Cross;
import step4.domain.Point;

class PointTest {
    @DisplayName("사다리 게임 첫번째 lane에서 양쪽 사다리가 없을 경우에는, 현재 위치를 고수한다.")
    @Test
    void first() {
        Point point = Point.first(false);
        assertThat(point.move()).isEqualTo(0);
    }

    @DisplayName("사다리 게임 첫번째 lane에서 오른쪽에 사다리가 존재할 경우, 위치는 1로 변경한다.")
    @Test
    void first2() {
        Point point = Point.first(true);
        assertThat(point.move()).isEqualTo(1);
    }

    @DisplayName("사다리 게임 두번째 lane에서 왼쪽에 사다리가 존재할 경우, 위치는 0으로 변경한다.")
    @Test
    void next() {
        Point point = Point.first(true).next(false);
        assertThat(point.move()).isEqualTo(0);
    }

    @DisplayName("사다리 게임 두번째 lane에서 오른쪽에 사다리가 존재할 경우, 위치는 2로 변경한다.")
    @Test
    void next2() {
        Point point = Point.first(false).next(true);
        assertThat(point.move()).isEqualTo(2);
    }

    @DisplayName("사다리 게임 두번째 lane에서 사다리가 존재하지 않을 경우, 위치는 1로 유지한다.")
    @Test
    void next3() {
        Point point = Point.first(false).next(false);
        assertThat(point.move()).isEqualTo(1);
    }

    @DisplayName("사다리 게임 세번째 lane에서 사다리가 오른쪽에 존재할 경우, 위치는 3으로 변경한다.")
    @Test
    void type2_next1() {

        Point point = new Point(1, new Cross(false, false));
        assertThat(point.next(true).move()).isEqualTo(3);
    }
}