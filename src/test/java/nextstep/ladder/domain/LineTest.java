package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    @Test
    @DisplayName("Point 리스트로부터 Line 을 잘 생성하는지")
    void from() {
        // given
        final Point first = Point.first(3, true);
        final Point second = first.next(true);
        final Point third = first.last();
        final List<Point> points = Arrays.asList(first, second, third);
        // when
        final Line actual = Line.from(points);
        // then
        assertThat(actual)
                .isInstanceOf(Line.class)
                .containsExactly(first, second, third);
    }
}