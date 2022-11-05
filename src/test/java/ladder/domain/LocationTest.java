package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class LocationTest {
    static Stream<Arguments> locationSuccessParam() {
        return Stream.of(
                Arguments.arguments(0, 1),
                Arguments.arguments(9, 10),
                Arguments.arguments(1, 3)
        );
    }

    @DisplayName("Location 생성 성공")
    @ParameterizedTest(name = "{displayName} {index} location: {0}| maxLocation: {1}")
    @MethodSource("locationSuccessParam")
    void locationSuccess(int location, int maxLocation) {
        new Location(location, maxLocation);
    }

    static Stream<Arguments> locationFailParam() {
        return Stream.of(
                Arguments.arguments(-1, 1),
                Arguments.arguments(10, 10),
                Arguments.arguments(3, 3)
        );
    }

    @DisplayName("Location 생성 실패")
    @ParameterizedTest(name = "{displayName} {index} location: {0}| maxLocation: {1}")
    @MethodSource("locationFailParam")
    void locationFail(int location, int maxLocation) {
        Throwable thrown = catchThrowable(() -> new Location(location, maxLocation));
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> movedPointParam() {
        return Stream.of(
                Arguments.arguments(
                        new Location(1, 3),
                        new Location(0, 3)
                ),
                Arguments.arguments(
                        new Location(10, 11),
                        new Location(9, 11)
                )
        );
    }

    @DisplayName("frontLocation 성공")
    @ParameterizedTest(name = "{displayName} {index}")
    @MethodSource("movedPointParam")
    void frontLocation(Location location, Location expectedLocation) {
        Location frontLocation = location.frontLocation();
        assertThat(frontLocation).isEqualTo(expectedLocation);
    }

    static Stream<Arguments> behindLocationParam() {
        return Stream.of(
                Arguments.arguments(
                        new Location(0, 3),
                        new Location(1, 3)
                ),
                Arguments.arguments(
                        new Location(10, 12),
                        new Location(11, 12)
                )
        );
    }

    @DisplayName("behindLocation 성공")
    @ParameterizedTest(name = "{displayName} {index}")
    @MethodSource("behindLocationParam")
    void behindLocation(Location location, Location expectedLocation) {
        Location frontLocation = location.behindLocation();
        assertThat(frontLocation).isEqualTo(expectedLocation);
    }

}