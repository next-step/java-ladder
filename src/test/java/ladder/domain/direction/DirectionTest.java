package ladder.domain.direction;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {

    @DisplayName("오른쪽의 다음 방향은 isNextRight 인자와 상관없이 왼쪽이다")
    @Test
    void right_next_left() {
        Direction right = Direction.RIGHT;
        Direction nextDirection = right.next(true);

        assertThat(nextDirection).isEqualTo(Direction.LEFT);
    }

    @DisplayName("왼쪽의 다음 방향은 isNextRight 인자에 따라 제자리이거나 오른쪽이다")
    @ParameterizedTest
    @MethodSource("notRight_nextIsGivenValueArguments")
    void notRight_nextIsGivenValue(boolean isNextRight, Direction expected) {
        Direction left = Direction.LEFT;
        Direction rightDirection = left.next(isNextRight);

        assertThat(rightDirection).isEqualTo(expected);
    }

    public static Stream<Arguments> notRight_nextIsGivenValueArguments() {
        return Stream.of(
                Arguments.of(true, Direction.RIGHT),
                Arguments.of(false, Direction.STAY));
    }

    @DisplayName("첫 번째 방향은 왼쪽일 수 없다")
    @Test
    void fist_not_left() {
        Direction direction = Direction.first(false);

        assertThat(direction).isNotEqualTo(Direction.LEFT);
    }

    @DisplayName("마지막 방향은 오른쪽일 수 없다")
    @Test
    void last_not_right() {
        Direction direction = Direction.last(false);

        assertThat(direction).isNotEqualTo(Direction.RIGHT);
    }
}
