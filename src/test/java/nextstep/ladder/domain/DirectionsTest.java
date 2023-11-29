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
    @DisplayName("성공 - 위치에서 이동한 후의 방향을 구한다.")
    void success_find_direction(int startPosition, int nextPosition) {
        Directions directions = new Directions(
                List.of(RIGHT, LEFT, STAY, STAY)
        );

        assertThat(directions.move(startPosition)).isEqualTo(nextPosition);
    }

    private static Stream<Arguments> provideDirection() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(1, 0),
                Arguments.of(2, 2),
                Arguments.of(3, 3)
        );
    }

}
