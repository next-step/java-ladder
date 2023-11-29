package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static nextstep.ladder.domain.Direction.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DirectionsTest {

    @ParameterizedTest
    @MethodSource("provideDirection")
    @DisplayName("성공 - 위치에 해당 하는 방향을 구한다.")
    void success_find_direction(int index, Direction direction) {
        Directions directions = new Directions(
                List.of(RIGHT, LEFT, STAY, STAY)
        );

        assertThat(directions.move(index)).isEqualTo(direction);
    }

    private static Stream<Arguments> provideDirection() {
        return Stream.of(
                Arguments.of(0, RIGHT),
                Arguments.of(1, LEFT),
                Arguments.of(2, STAY),
                Arguments.of(3, STAY)
        );
    }

}
