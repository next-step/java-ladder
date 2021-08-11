package nextstep.ladder.domain.laddar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;

/**
 * Direction은 현재 위치에서 갈 수 있는 방향에 대한 판단을 한다. 이러한 판단을 위해 내부적으로 상태값을 가지며 이 상태는 처음 초기화 이후 변경할 수 없어야 한다.
 */
public class DirectionTest {
    @Test
    @DisplayName("객체 초기화 시 null이 입력되면 즉시 NPE를 발생시킨다.")
    void firstNpe() {
        Assertions.assertThatThrownBy(() -> Direction.createFirst(null))
                  .isInstanceOf(NullPointerException.class);
    }

    @MethodSource
    @ParameterizedTest
    @DisplayName("현재 위치는 가장 왼쪽이다. 따라서 더이상 왼쪽으로 갈 수 없다.")
    void first(final boolean first, final Direction expectedDirection, final boolean isRight, final boolean isLeft) {
        Direction firstDirection = Direction.createFirst(() -> first);

        assertAll(
                () -> Assertions.assertThat(firstDirection).isEqualTo(expectedDirection),
                () -> Assertions.assertThat(firstDirection.isRight()).isEqualTo(isRight)
        );
    }

    private static Stream<Arguments> first() {
        return Stream.of(
                Arguments.of(true, Direction.RIGHT, true, false),
                Arguments.of(false, Direction.SOUTH, false, false)
        );
    }

    @MethodSource
    @ParameterizedTest
    @DisplayName("현재 위치는 가장 오른쪽이다. 따라서 오른쪽으로는 더이상 갈 수 없으며 왼쪽 아니면 아래쪽으로만 갈 수 있다.")
    void last(final boolean first, final boolean next, final Direction expectedDirection, final boolean isRight, final boolean isLeft) {
        Direction lastDirection = Direction.createFirst(() -> first).createNext(() -> next).createLast();
        assertAll(
                () -> Assertions.assertThat(lastDirection).isEqualTo(expectedDirection),
                () -> Assertions.assertThat(lastDirection.isRight()).isEqualTo(isRight)
        );
    }

    private static Stream<Arguments> last() {
        return Stream.of(
                Arguments.of(false, false, Direction.SOUTH, false, false),
                Arguments.of(true, false, Direction.SOUTH, false, false),
                Arguments.of(false, true, Direction.LEFT, false, true)
        );
    }
}
