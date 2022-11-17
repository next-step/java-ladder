package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @DisplayName("첫번째 Point 생성 시 left 는 false 이다.")
    @Test
    void create_first() {
        // given
        boolean current = true;

        // when
        Point first = Point.first(current);

        // then
        assertThat(first).isEqualTo(Point.first(current));
    }

    @DisplayName("next 실행 시 left 가 true, current 가 true 면 current 는 자동으로 false 가 된다.")
    @Test
    void next() {
        // given
        boolean current = true;

        // when
        Point first = Point.first(current);
        Point next = first.next(false);

        // then
        assertThat(next).isEqualTo(Point.first(current).next(false));
    }

    @DisplayName("last 실행 시 current 는 항상 false 이다.")
    @Test
    void last() {
        // given
        boolean current = true;

        // when
        Point first = Point.first(current);
        Point next = first.next(true);
        Point last = next.last();

        // then
        assertThat(last).isEqualTo(Point.first(current).next(true).last());
    }

}
