package ladder.domain.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static ladder.domain.ladder.Direction.MAXIMUM_DIRECTION_IS_ONE;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class DirectionTest {
    @DisplayName("방향은 왼쪽 오른쪽 중 최대 하나만 선택 가능")
    @Test
    void valueOf_throw_exception() {
        // given
        final boolean left = true;
        final boolean right = true;

        // when 
        final Throwable thrown = catchThrowable(() -> {
            Direction.valueOf(left, right);
        });

        // then
        Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MAXIMUM_DIRECTION_IS_ONE);
    }

    @DisplayName("전달인자에 맞게 방향 enum 반환")
    @ParameterizedTest
    @CsvSource(value = {
            "true:false:LEFT",
            "false:true:RIGHT",
            "false:false:NONE"
    }, delimiter = ':')
    void valueOf(final boolean left, final boolean right, final Direction expectedDirection) {
        // whenRIGHT
        final Direction actualDirection = Direction.valueOf(left, right);

        // then
        assertThat(actualDirection).isEqualTo(expectedDirection);
    }

    @DisplayName("오른쪽 방향으로 한칸 이동")
    @Test
    void move_right() {
        // given
        final int index = 0;
        final Direction direction = Direction.RIGHT;

        // when
        final int afterMovePosition = direction.move(index);

        // then
        assertThat(afterMovePosition).isEqualTo(index + 1);
    }

    @DisplayName("왼쪽 방향으로 한칸 이동")
    @Test
    void move_left() {
        // given
        final int index = 1;
        final Direction direction = Direction.LEFT;

        // when
        final int afterMovePosition = direction.move(index);

        // then
        assertThat(afterMovePosition).isEqualTo(index - 1);
    }

    @DisplayName("기존 사다리 유지")
    @Test
    void not_move() {
        // given
        final int index = 1;
        final Direction direction = Direction.NONE;

        // when
        final int afterMovePosition = direction.move(index);

        // then
        assertThat(afterMovePosition).isEqualTo(index);
    }
}