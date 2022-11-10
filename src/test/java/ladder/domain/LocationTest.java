package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LocationTest {
    static Stream<Arguments> frontLocationParam() {
        return Stream.of(
                Arguments.arguments(
                        new Location(1),
                        new Location(0)
                ),
                Arguments.arguments(
                        new Location(10),
                        new Location(9)
                )
        );
    }

    @DisplayName("frontLocation 성공")
    @ParameterizedTest(name = "{displayName} {index}")
    @MethodSource("frontLocationParam")
    void frontLocation(Location location, Location expectedLocation) {
        Location frontLocation = location.frontLocation();
        assertThat(frontLocation).isEqualTo(expectedLocation);
    }

    static Stream<Arguments> behindLocationParam() {
        return Stream.of(
                Arguments.arguments(
                        new Location(0),
                        new Location(1)
                ),
                Arguments.arguments(
                        new Location(10),
                        new Location(11)
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

    static Stream<Arguments> compareToParam() {
        return Stream.of(
                Arguments.arguments(
                        new Location(0),
                        new Location(1),
                        -1
                ),
                Arguments.arguments(
                        new Location(1),
                        new Location(0),
                        1
                ),
                Arguments.arguments(
                        new Location(0),
                        new Location(0),
                        0
                ),
                Arguments.arguments(
                        new Location(123),
                        new Location(12),
                        1
                )
        );
    }

    @DisplayName("compareTo 성공")
    @ParameterizedTest(name = "{displayName} {index}")
    @MethodSource("compareToParam")
    void compareTo(Location location, Location targetLocation, int expectedResult) {
        int compareResult = location.compareTo(targetLocation);
        assertThat(compareResult).isEqualTo(expectedResult);
    }
}