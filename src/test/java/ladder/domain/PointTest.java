package ladder.domain;

import ladder.exception.PointException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.domain.Point.NOT_ALLOWED_CONSECUTIVE_LINE_MESSAGE;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class PointTest {
    @Test
    @DisplayName("첫번째 포인트를 생성한다")
    void first() {
        Point actual = Point.first(true);
        Point expected = Point.first(true);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("중간 포인트를 생성한다")
    void next() {
        Point actual = Point
                .first(true).next(false);
        Point expected = Point.first(false)
                .next(true).next(false);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("마지막 포인트를 생성한다")
    void last() {
        Point actual = Point.first(false)
                .next(true).last();
        Point expected = Point.first(true).next(false)
                .next(true).last();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("포인트 생성 오류: 라인이 나란히 있을 경우 오류가 발생한다")
    void create_나란히_line_있을_경우_에러() {
        assertThatThrownBy(() -> Point.first(true).next(true))
                .isInstanceOf(PointException.class)
                .hasMessage(NOT_ALLOWED_CONSECUTIVE_LINE_MESSAGE);
    }

    @Test
    @DisplayName("현재 포인트를 출력한다")
    void getCurrent() {
        // f t f t f
        Point first = Point.first(true);
        Point next1 = first.next(false);
        Point next2 = next1.next(true);

        boolean firstCurrent = first.getCurrent();
        boolean firstCurrentExpected = true;

        boolean next1Current = next1.getCurrent();
        boolean next1CurrentExpected = false;

        boolean next2Current = next2.getCurrent();
        boolean next2CurrentExpected = true;

        assertThat(firstCurrent).isEqualTo(firstCurrentExpected);
        assertThat(next1Current).isEqualTo(next1CurrentExpected);
        assertThat(next2Current).isEqualTo(next2CurrentExpected);
    }

    @Test
    @DisplayName("이전 포인트를 출력한다")
    void getPrev() {
        // f t f t f
        Point first = Point.first(true);
        Point next1 = first.next(false);
        Point next2 = next1.next(true);

        boolean firstCurrent = first.getPrev();
        boolean firstCurrentExpected = false;

        boolean next1Current = next1.getPrev();
        boolean next1CurrentExpected = true;

        boolean next2Current = next2.getPrev();
        boolean next2CurrentExpected = false;

        assertThat(firstCurrent).isEqualTo(firstCurrentExpected);
        assertThat(next1Current).isEqualTo(next1CurrentExpected);
        assertThat(next2Current).isEqualTo(next2CurrentExpected);
    }
}