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

    static Stream<Arguments> isLastTrueParam() {
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
    @MethodSource("isLastTrueParam")
    void isLastTrue(Line line, boolean expectedBoolean) {
        boolean lastTrue = line.isLastTrue();
        assertThat(lastTrue).isEqualTo(expectedBoolean);
    }

    @DisplayName("Line의 마지막 요소 true인지 체크: 길이가 0일때 에러발생")
    @Test
    void isLastTrueFail() {
        Line line = new Line(new ArrayList<>(List.of()));
        Throwable thrown = catchThrowable(line::isLastTrue);
        assertThat(thrown).isInstanceOf(IndexOutOfBoundsException.class);
    }

    static Stream<Arguments> isLeftEdgeParam() {
        return Stream.of(
                Arguments.arguments(new Line(new ArrayList<>(List.of(true))), 0, true),
                Arguments.arguments(new Line(new ArrayList<>(List.of(true))), -1, false),
                Arguments.arguments(new Line(new ArrayList<>(List.of(true))), 10, true)
        );
    }

    @DisplayName("Line의 왼쪽 끝 범위를 벗어났는지 확인")
    @ParameterizedTest(name = "{displayName} {index}")
    @MethodSource("isLeftEdgeParam")
    void isLeftEdge(Line line, int index, boolean expectedBoolean) {
        boolean leftEdge = line.isLeftEdge(index);
        assertThat(leftEdge).isEqualTo(expectedBoolean);
    }

    static Stream<Arguments> isRightEdgeParam() {
        return Stream.of(
                Arguments.arguments(new Line(new ArrayList<>(List.of(true))), 1, false),
                Arguments.arguments(new Line(new ArrayList<>(List.of(true))), 0, true),
                Arguments.arguments(new Line(new ArrayList<>(List.of(true, false, true, false))), 4, false),
                Arguments.arguments(new Line(new ArrayList<>(List.of(true, false, true, false))), 3, true),
                Arguments.arguments(new Line(new ArrayList<>(List.of(true, false, true, false))), 0, true)
        );
    }

    @DisplayName("Line의 오른쪽 끝 범위를 벗어났는지 확인")
    @ParameterizedTest(name = "{displayName} {index}")
    @MethodSource("isRightEdgeParam")
    void isRightEdge(Line line, int index, boolean expectedBoolean) {
        boolean leftEdge = line.isRightEdge(index);
        assertThat(leftEdge).isEqualTo(expectedBoolean);
    }

    static Stream<Arguments> isRoadExistParam() {
        return Stream.of(
                Arguments.arguments(new Line(new ArrayList<>(List.of(true))), 0, true),
                Arguments.arguments(new Line(new ArrayList<>(List.of(false))), 0, false),
                Arguments.arguments(new Line(new ArrayList<>(List.of(true, false, true))), 0, true),
                Arguments.arguments(new Line(new ArrayList<>(List.of(true, false, true))), 1, false),
                Arguments.arguments(new Line(new ArrayList<>(List.of(true, false, true))), 2, true)
        );
    }

    @DisplayName("Line애서 해당index에 길이 존재하는지 확인")
    @ParameterizedTest(name = "{displayName} {index}")
    @MethodSource("isRoadExistParam")
    void isRoadExist(Line line, int index, boolean expectedBoolean) {
        boolean leftEdge = line.isRoadExist(index);
        assertThat(leftEdge).isEqualTo(expectedBoolean);
    }
}