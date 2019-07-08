package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PointTest {
    @Test
    @DisplayName("첫 번째 Point 가 잘 생성되는지")
    void first() {
        final Point actual = Point.first(5, true);
        assertThat(actual).isInstanceOf(Point.class);
    }

    @Test
    @DisplayName("다음 Point 가 잘 생성되는지")
    void next() {
        final Point first = Point.first(2, true);
        final Point actual = first.next(false);
        assertThat(actual).isInstanceOf(Point.class);
    }

    @Test
    @DisplayName("마지막 Point 가 잘 생성되는지")
    void last() {
        final Point first = Point.first(2, true);
        final Point actual = first.last();
        assertThat(actual).isInstanceOf(Point.class);
    }

    @Test
    @DisplayName("size 보다 Point 개수가 많아지면 예외 발생")
    void next_size_exception() {
        final Point first = Point.first(1, true);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> first.next(false));
    }
}