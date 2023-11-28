package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DirectionTest {

    @ParameterizedTest
    @MethodSource("provideDirection")
    @DisplayName("성공 - 숫자 값에 따른 방향을 찾는다.")
    void success_find_direction(int value, Direction direction) {
        assertThat(Direction.of(value)).isEqualTo(direction);
    }

    private static Stream<Arguments> provideDirection() {
        return Stream.of(
                Arguments.of(-1, Direction.LEFT),
                Arguments.of(0, Direction.STAY),
                Arguments.of(1, Direction.RIGHT)
        );
    }

    @ParameterizedTest
    @MethodSource("provideDirectionAndPosition")
    @DisplayName("성공 - 처음 위치에서 방향에 따라 위치값이 수정된다.")
    void success_move(int initPosition, Direction direction, int expectPosition) {
        assertThat(direction.move(initPosition)).isEqualTo(expectPosition);
    }

    private static Stream<Arguments> provideDirectionAndPosition() {
        return Stream.of(
                Arguments.of(1, Direction.LEFT, 0),
                Arguments.of(1, Direction.STAY, 1),
                Arguments.of( 1, Direction.RIGHT, 2)
        );
    }


    @ParameterizedTest
    @CsvSource(value = {"-2", "2"})
    @DisplayName("실패 - 숫자 값에 따른 방향을 찾지 못한다.")
    void fail_find_direction(int value) {
        Assertions.assertThatThrownBy(() -> Direction.of(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자 값에 따른 Direction을 찾을 수 없습니다.");
    }

}
