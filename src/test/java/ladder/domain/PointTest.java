package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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

    static Stream<Arguments> frontPointParam() {
        return Stream.of(
                Arguments.arguments(
                        new Point("kero", 1, 2),
                        new Point("kero", 0, 2)
                ),
                Arguments.arguments(
                        new Point("kero", 2, 3),
                        new Point("kero", 1, 3)
                ),
                Arguments.arguments(
                        new Point("kero", 100, 101),
                        new Point("kero", 99, 101)
                )
        );
    }

    @DisplayName("frontPoint 성공")
    @ParameterizedTest(name = "{displayName} {index}")
    @MethodSource("frontPointParam")
    void frontPoint(Point point, Point expectedPoint) {
        Point frontPoint = point.frontPoint();
        assertThat(frontPoint).isEqualTo(expectedPoint);
    }

    static Stream<Arguments> behindPointParam() {
        return Stream.of(
                Arguments.arguments(
                        new Point("kero", 0, 2),
                        new Point("kero", 1, 2)
                ),
                Arguments.arguments(
                        new Point("kero", 1, 3),
                        new Point("kero", 2, 3)
                ),
                Arguments.arguments(
                        new Point("kero", 99, 101),
                        new Point("kero", 100, 101)
                )
        );
    }

    @DisplayName("behindPoint 성공")
    @ParameterizedTest(name = "{displayName} {index}")
    @MethodSource("behindPointParam")
    void behindPoint(Point point, Point expectedPoint) {
        Point behindPoint = point.behindPoint();
        assertThat(behindPoint).isEqualTo(expectedPoint);
    }
}