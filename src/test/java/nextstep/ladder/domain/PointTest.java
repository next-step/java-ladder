package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class PointTest {

    @DisplayName("현재 위치를 구한다")
    @ParameterizedTest
    @MethodSource("provideMoveCurrentPoint")
    void current_point(final boolean left, final boolean right, final int index, final int expected) {

        final Movement movement = Movement.first(left).next(right);
        final Point point = new Point(index, movement);
        assertThat(point.move()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideMoveCurrentPoint() {
        return Stream.of(
                Arguments.of(false, false, 1, 1),
                Arguments.of(false, true, 1, 2),
                Arguments.of(true, false, 1, 0)
        );
    }

    @DisplayName("다음 위치를 구한다.")
    @Test
    void next_point() {

        final Point point = new Point(0, Movement.first(true));
        final Point next = point.next(true);

        assertThat(next).isEqualTo(new Point(1, Movement.first(true).next(false)));
    }

    @DisplayName("첫번째를 제외한 수만큼 포인트를 생성한다.")
    @ParameterizedTest
    @CsvSource(value = {"0,true", "1,true", "2,true", "3,true", "4,false"})
    void last_index(final int index, final boolean expected) {

        final Point point = new Point(index, Movement.first(true));
        assertThat(point.untilExcludeStart(index, 5)).isEqualTo(expected);
    }
}