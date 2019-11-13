package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Optional;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {
    @ParameterizedTest
    @MethodSource(value = "providePreviousDirection")
    @DisplayName("이전 Direction을 받았을때 랜덤 Direction값을 확인한다.")
    void getRandomDirectionByPreviousDirection(Optional<Direction> direction, Direction[] directions) {
        assertThat(Direction.getRandomDirection(direction)).isIn(directions);
    }

    private static Stream<Arguments> providePreviousDirection() {
        Direction[] directions = {Direction.RIGHT, Direction.BOTTOM};
        Direction[] leftDirection = {Direction.LEFT};

        return Stream.of(
                Arguments.of(Optional.empty(), Direction.values()),
                Arguments.of(Optional.of(Direction.LEFT), directions),
                Arguments.of(Optional.of(Direction.BOTTOM), directions),
                Arguments.of(Optional.of(Direction.RIGHT), leftDirection)
        );
    }
}
