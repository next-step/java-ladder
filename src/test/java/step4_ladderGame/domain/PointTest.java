package step4_ladderGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PointTest {

    @DisplayName("Point의 이전값과 현재값이 둘다 true일 수 없다.")
    @Test
    void testCase1() {
        assertThatThrownBy(() -> {
            Point.of(true, true);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("첫번째 사다리 Point의 prevPoint는 무조건 false여야 한다.")
    @Test
    void testCase2() {
        Point first = Point.first(true);

        assertThat(first).isEqualTo(Point.of(false, true));
    }

    @DisplayName("사다리의 다음 값은 curPoint가 prevPoint로 들어가고 새로운 nextPoint값이 culPoint로 만들어 져야 한다.")
    @Test
    void testCase3() {
        Point first = Point.first(true);

        Point next = first.next(false);

        assertThat(next).isEqualTo(Point.of(true, false));
    }

    @DisplayName("마지막 사다리 Point의 curPoint는 무조건 false 여야 한다.")
    @Test
    void testCase4() {
        Point point = Point.of(false, true);

        Point last = point.last();

        assertThat(last).isEqualTo(Point.of(true, false));
    }
}