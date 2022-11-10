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
    static Stream<Arguments> addedLineParam() {
        return Stream.of(
                Arguments.arguments(
                        new Line(new ArrayList<>(List.of(false))),
                        false,
                        new Line(new ArrayList<>(List.of(false, false)))
                ),
                Arguments.arguments(
                        new Line(new ArrayList<>(List.of(true))),
                        false,
                        new Line(new ArrayList<>(List.of(true, false)))
                ),
                Arguments.arguments(
                        new Line(new ArrayList<>(List.of(true, false, false, false))),
                        true,
                        new Line(new ArrayList<>(List.of(true, false, false, false, true)))
                )
        );
    }

    @DisplayName("Line에 point 추가 성공")
    @ParameterizedTest(name = "{displayName} {index} expectedLines: {2}")
    @MethodSource("addedLineParam")
    void addedLine(Line line, boolean point, Line expectedLine) {
        Line addedLine = line.addedLine(point);
        assertThat(addedLine).isEqualTo(expectedLine);
    }

    static Stream<Arguments> lastParam() {
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
    @ParameterizedTest(name = "{displayName} {index}")
    @MethodSource("lastParam")
    void last(Line line, boolean expectedBoolean) {
        boolean lastTrue = line.last();
        assertThat(lastTrue).isEqualTo(expectedBoolean);
    }

    @DisplayName("Line의 마지막 요소 true인지 체크: 길이가 0일때 에러발생")
    @Test
    void lastFail() {
        Line line = new Line(new ArrayList<>(List.of()));
        Throwable thrown = catchThrowable(line::last);
        assertThat(thrown).isInstanceOf(IndexOutOfBoundsException.class);
    }

    static Stream<Arguments> movableToLeftParam() {
        return Stream.of(
                Arguments.arguments(new Line(new ArrayList<>(List.of(true))), 0, false),
                Arguments.arguments(new Line(new ArrayList<>(List.of(true))), 1, true),
                Arguments.arguments(new Line(new ArrayList<>(List.of(false, false, false, false, true))), 5, true)
        );
    }

    @DisplayName("line에서 인자로 받은 위치의 왼쪽으로 이동 가능한지 확인")
    @ParameterizedTest(name = "{displayName} {index}")
    @MethodSource("movableToLeftParam")
    void movableToLeft(Line line, int index, boolean expectedBoolean) {
        boolean movableToLeft = line.movableToLeft(index);
        assertThat(movableToLeft).isEqualTo(expectedBoolean);
    }

    static Stream<Arguments> movableToRightParam() {
        return Stream.of(
                Arguments.arguments(new Line(new ArrayList<>(List.of(true))), 0, true),
                Arguments.arguments(new Line(new ArrayList<>(List.of(false))), 0, false),
                Arguments.arguments(new Line(new ArrayList<>(List.of(true))), 1, false),
                Arguments.arguments(new Line(new ArrayList<>(List.of(true, false, false, true))), 4, false),
                Arguments.arguments(new Line(new ArrayList<>(List.of(true, false, false, true))), 3, true),
                Arguments.arguments(new Line(new ArrayList<>(List.of(true, false, true, false))), 0, true)
        );
    }

    @DisplayName("line에서 인자로 받은 위치의 오른쪽으로 이동 가능한지 확인")
    @ParameterizedTest(name = "{displayName} {index}")
    @MethodSource("movableToRightParam")
    void movableToRight(Line line, int index, boolean expectedBoolean) {
        boolean leftEdge = line.movableToRight(index);
        assertThat(leftEdge).isEqualTo(expectedBoolean);
    }
}