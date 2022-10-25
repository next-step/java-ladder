package ladder.domain;

import static ladder.domain.Point.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PointTest {
    @DisplayName("다음에 수평선을 추가할 수 있다면 true 를 리턴하고 없다면 false 를 리턴한다.")
    @ParameterizedTest
    @MethodSource("canAddHorizonNextTimeSet")
    void canAddHorizonNextTime(List<Point> points, boolean expected) {
        assertThat(Point.canAddHorizonNextTime(points)).isEqualTo(expected);
    }

    @DisplayName("이전 포인트가 수직선이라면 이번에는 수평선 / 공백이 오고, 수직선이 아니라면 수직선이 온다.")
    @ParameterizedTest
    @MethodSource("nextSet")
    void next(Point before, List<Point> expected) {
        assertThat(Point.next(before)).containsExactlyElementsOf(expected);
    }

    private static Stream<Arguments> canAddHorizonNextTimeSet() {
        return Stream.of(
                Arguments.arguments(List.of(HORIZON, HORIZON, VERTICAL_LINE), false),
                Arguments.arguments(List.of(HORIZON, VERTICAL_LINE, BLANK), true),
                Arguments.arguments(List.of(VERTICAL_LINE, HORIZON, VERTICAL_LINE), false),
                Arguments.arguments(List.of(VERTICAL_LINE), true),
                Arguments.arguments(List.of(HORIZON), true),
                Arguments.arguments(List.of(BLANK), true)
        );
    }

    private static Stream<Arguments> nextSet() {
        return Stream.of(
                Arguments.arguments(VERTICAL_LINE, List.of(HORIZON, BLANK)),
                Arguments.arguments(BLANK, List.of(VERTICAL_LINE)),
                Arguments.arguments(HORIZON, List.of(VERTICAL_LINE))
        );
    }
}
