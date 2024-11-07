package ladder.domain;

import ladder.exception.PointException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static ladder.domain.Point.NOT_ALLOWED_CONSECUTIVE_LINE_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class PointTest {
    @Test
    void first() {
        Point actual = Point.first(true);
        Point expected = Point.first(true);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void next() {
        Point actual = Point
                .first(true).next(false);
        Point expected = Point.first(false)
                .next(true).next(false);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void last() {
        Point actual = Point.first(false)
                .next(true).last();
        Point expected = Point.first(true).next(false)
                .next(true).last();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void create_나란히_line_있을_경우_에러() {
        assertThatThrownBy(() -> Point.first(true).next(true))
                .isInstanceOf(PointException.class)
                .hasMessage(NOT_ALLOWED_CONSECUTIVE_LINE_MESSAGE);
    }

    @Test
    void getRight() {
        // f t f t f
        Point first = Point.first(true);
        Point next1 = first.next(false);
        Point next2 = next1.next(true);
        Point last = next2.last();

        boolean firstCurrent = first.getCurrent();
        boolean firstCurrentExpected = true;

        boolean next1Current = next1.getCurrent();
        boolean next1CurrentExpected = false;

        boolean next2Current = next2.getCurrent();
        boolean next2CurrentExpected = true;

        Assertions.assertThat(firstCurrent).isEqualTo(firstCurrentExpected);
        Assertions.assertThat(next1Current).isEqualTo(next1CurrentExpected);
        Assertions.assertThat(next2Current).isEqualTo(next2CurrentExpected);
    }
}