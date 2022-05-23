package nextstep.ladder.model;

import nextstep.ladder.model.ladder.Point;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PointTest {

    @Test
    void init() {
        assertAll(() -> assertThat(Point.first(TRUE).move()).isEqualTo(1),
                () -> assertThat(Point.first(FALSE).move()).isEqualTo(0));
    }

    @Test
    void next() {
        assertThat(Point.first(TRUE).next().move()).isEqualTo(0);
    }

    @ParameterizedTest(name = "대기 / 좌측 / 우측 이동 - {index}")
    @MethodSource("points")
    void next_stay_and_left_and_right(boolean firstRight, boolean nextRight, int column) {
        assertThat(Point.first(firstRight).next(nextRight).move()).isEqualTo(column);
    }

    private static Stream<Arguments> points() {
        return Stream.of(
                Arguments.of(FALSE, FALSE, 1),
                Arguments.of(TRUE, FALSE, 0),
                Arguments.of(FALSE, TRUE, 2)
        );
    }
}
