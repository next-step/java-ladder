package ladder.model;

import ladder.exception.InvalidLineException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {

    @ParameterizedTest
    @MethodSource("lineProvider")
    @DisplayName("연속적으로 연결되지 않았을 경우 정상적인 라인을 생성한다")
    void createLine(List<Point> points) {
        assertThat(Line.create(points)).isInstanceOf(Line.class);
    }

    public static Stream<Arguments> lineProvider() {
        return Stream.of(
                Arguments.of(
                        List.of(
                                Point.of(0, Direction.of(false, true)),
                                Point.of(0, Direction.of(true, false)),
                                Point.of(0, Direction.of(false, true)),
                                Point.of(0, Direction.of(true, false)),
                                Point.of(0, Direction.of(false, false))
                        )
                )
        );
    }

    @ParameterizedTest
    @MethodSource("invalidLineProvider")
    @DisplayName("올바르지 않은 라인일 경우 예외를 반환한다")
    void throwInvalidLineException(List<Point> points) {
        assertThatThrownBy(() -> Line.create(points)).isInstanceOf(InvalidLineException.class);
    }

    public static Stream<Arguments> invalidLineProvider() {
        return Stream.of(
                Arguments.of(
                        List.of(
                                Point.of(0, Direction.of(false, true)),
                                Point.of(0, Direction.of(true, true)),
                                Point.of(0, Direction.of(true, true)),
                                Point.of(0, Direction.of(true, false)),
                                Point.of(0, Direction.of(false, false))
                        )
                )
        );
    }

}