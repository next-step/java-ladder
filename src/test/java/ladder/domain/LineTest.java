package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class LineTest {
    static Stream<Arguments> addPointParam() {
        return Stream.of(
                Arguments.arguments(
                        new Line(new ArrayList<>(List.of())),
                        true,
                        new Line(new ArrayList<>(List.of(true)))
                ),
                Arguments.arguments(
                        new Line(new ArrayList<>(List.of())),
                        false,
                        new Line(new ArrayList<>(List.of(false)))
                ),
                Arguments.arguments(
                        new Line(new ArrayList<>(List.of(true))),
                        false,
                        new Line(new ArrayList<>(List.of(true, false)))
                ),
                Arguments.arguments(
                        new Line(new ArrayList<>(List.of(false))),
                        false,
                        new Line(new ArrayList<>(List.of(false, false)))
                ),
                Arguments.arguments(
                        new Line(new ArrayList<>(List.of(true, false, false, false))),
                        true,
                        new Line(new ArrayList<>(List.of(true, false, false, false, true)))
                )
        );
    }

    @DisplayName("Line에 point 추가")
    @ParameterizedTest(name = "{displayName} {index} expectedLines: {2}")
    @MethodSource("addPointParam")
    void addPoint(Line line, boolean point, Line expectedLine) {
        Line addedLine = line.addPoint(point);
        assertThat(addedLine.getLine()).isEqualTo(expectedLine.getLine());
    }

    static Stream<Arguments> isLastPointTrueParam() {
        return Stream.of(
                Arguments.arguments(
                        new Line(new ArrayList<>(List.of(true))),
                        true
                ),
                Arguments.arguments(
                        new Line(new ArrayList<>(List.of(false))),
                        false
                ),
                Arguments.arguments(
                        new Line(new ArrayList<>(List.of(false, false, true, false, true))),
                        true
                ),
                Arguments.arguments(
                        new Line(new ArrayList<>(List.of(true, false, true, false))),
                        false
                )
        );
    }

    @DisplayName("Line의 마지막 요소 true인지 체크")
    @ParameterizedTest(name = "{displayName} {index} expectedLines: {0}")
    @MethodSource("isLastPointTrueParam")
    void isLastPointTrue(Line line, boolean expectedBoolean) {
        boolean lastPointTrue = line.isLastPointTrue();
        assertThat(lastPointTrue).isEqualTo(expectedBoolean);
    }

    @DisplayName("Line의 마지막 요소 true인지 체크: 길이가 0일때 에러발생")
    @Test
    void isLastPointTrueException() {
        Line line = new Line(new ArrayList<>(List.of()));
        Throwable thrown = catchThrowable(line::isLastPointTrue);
        assertThat(thrown).isInstanceOf(IndexOutOfBoundsException.class);
    }
}