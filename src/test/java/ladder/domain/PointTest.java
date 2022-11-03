package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class PointTest {
    static Stream<Arguments> pointSuccessParam() {
        return Stream.of(
                Arguments.arguments("kero", 0, 1),
                Arguments.arguments("giro", 9, 10),
                Arguments.arguments("zero", 1, 3)
        );
    }

    @DisplayName("point 생성 성공")
    @ParameterizedTest(name = "{displayName} {index} location: {1}| maxLocation: {2}")
    @MethodSource("pointSuccessParam")
    void pointSuccess(String name, int location, int maxLocation) {
        new Point(name, location, maxLocation);
    }

    static Stream<Arguments> pointFailParam() {
        return Stream.of(
                Arguments.arguments("kero", -1, 1),
                Arguments.arguments("giro", 10, 10),
                Arguments.arguments("zero", 3, 3)
        );
    }

    @DisplayName("point 생성 실패")
    @ParameterizedTest(name = "{displayName} {index} location: {1}| maxLocation: {2}")
    @MethodSource("pointFailParam")
    void pointFail(String name, int location, int maxLocation) {
        Throwable thrown = catchThrowable(() -> new Point(name, location, maxLocation));
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> movedPointParam() {
        return Stream.of(
                Arguments.arguments(
                        new Line(new ArrayList<>(List.of(true))),
                        new Point("kero", 0, 2),
                        new Point("kero", 1, 2)
                ),
                Arguments.arguments(
                        new Line(new ArrayList<>(List.of(false))),
                        new Point("kero", 0, 2),
                        new Point("kero", 0, 2)
                ),
                Arguments.arguments(
                        new Line(new ArrayList<>(List.of(true, false))),
                        new Point("kero", 1, 3),
                        new Point("kero", 0, 3)
                ),
                Arguments.arguments(
                        new Line(new ArrayList<>(List.of(false, true))),
                        new Point("kero", 1, 3),
                        new Point("kero", 2, 3)
                )
        );
    }

    @DisplayName("movedPoint 성공")
    @ParameterizedTest(name = "{displayName} {index}")
    @MethodSource("movedPointParam")
    void movedPoint(Line line, Point point, Point expectedPoint) {
        Point movedPoint = point.movedPoint(line);
        assertThat(movedPoint).isEqualTo(expectedPoint);
    }
}