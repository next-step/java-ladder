package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DirectionTest {
    @ParameterizedTest(name = "{0}, {1}")
    @CsvSource({
            "false, true, RIGHT",
            "true, false, LEFT",
            "false, false, NONE"
    })
    @DisplayName("방향 생성")
    void create(boolean left, boolean right, Direction expected) {
        // given
        Direction direction = Direction.of(left, right);

        // when
        assertThat(direction).isSameAs(expected);
    }


    @Test
    @DisplayName("두 방향 true 예외")
    void createException() {
        assertThatThrownBy(() -> Direction.of(true, true))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"LEFT, -1", "RIGHT, 1", "NONE, 0"}, delimiter = ',')
    @DisplayName("방향에 따라 움직이는 방향 확인")
    void move(Direction direction, int expected) {
        // when
        int actual = direction.move();

        assertThat(actual).isEqualTo(expected);
    }
}