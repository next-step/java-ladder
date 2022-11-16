package laddergame.domain;

import laddergame.exception.ErrorCode;
import laddergame.exception.LadderGameException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DirectionTest {
    public static Stream<Arguments> provideNextBooleanAndDirections() {
        return Stream.of(
                Arguments.of(new Direction(false, true), true, new Direction(true, false)),
                Arguments.of(new Direction(false, true), false, new Direction(true, false)),
                Arguments.of(new Direction(false, false), true, new Direction(false, true)),
                Arguments.of(new Direction(true, false), false, new Direction(false, false))
        );
    }

    public static Stream<Arguments> provideDirectionAndMoveResult() {
        return Stream.of(
                Arguments.of(new Direction(false, true), 1),
                Arguments.of(new Direction(true, false), -1),
                Arguments.of(new Direction(false, false), 0)
        );
    }

    @Test
    void 왼쪽_오른쪽_모두_true_불가() {
        assertThatThrownBy(() -> new Direction(true, true))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ErrorCode.LADDER_LINE_EXIT_CONTINOUSLY.getMessage());
    }

    @ParameterizedTest
    @ValueSource(booleans = {false, true})
    void 첫_Point_생성(boolean right) {
        assertThat(Direction.first(right)).isEqualTo(new Direction(false, right));
    }

    @ParameterizedTest
    @ValueSource(booleans = {false, true})
    void 마지막_Point_생성(boolean right) {
        assertThat(new Direction(false, right).last()).isEqualTo(new Direction(right, false));
    }

    @ParameterizedTest
    @MethodSource("provideNextBooleanAndDirections")
    void 다음_Point_Direction_생성(Direction now, boolean next, Direction expected) {
        assertThat(now.next(next)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("provideDirectionAndMoveResult")
    void 이동(Direction direction, int moved) {
        assertThat(direction.move()).isEqualTo(moved);
    }
}

