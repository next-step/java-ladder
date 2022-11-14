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
        Point first = Point.first(() -> current);

        // then
        assertThat(first).isEqualTo(new Point(false, true, 0));
    }

    @DisplayName("next 실행 시 left 가 true, current 가 true 면 current 는 자동으로 false 가 된다. / 인덱스가 1 증가한다.")
    @Test
    void next() {
        // given
        boolean current = true;

        // when
        Point first = Point.first(() -> current);
        Point next = first.next(() -> false);

        // then
        assertThat(next).isEqualTo(new Point(true, false, 1));
    }

    @DisplayName("last 실행 시 current 는 항상 false 이다. / 인덱스가 1 증가한다.")
    @Test
    void last() {
        // given
        boolean current = true;

        // when
        Point first = Point.first(() -> current);
        Point next = first.next(() -> true);
        Point last = next.last();

        // then
        assertThat(last).isEqualTo(new Point(false, false, 2));
    }

}
