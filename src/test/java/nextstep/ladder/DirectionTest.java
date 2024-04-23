package nextstep.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {

    @Test
    void left() {
        Direction direction = new Direction(true, false);

        assertThat(direction.move()).isEqualTo(-1);
    }

    @Test
    void right() {
        Direction direction = new Direction(false, true);

        assertThat(direction.move()).isEqualTo(1);
    }

    @Test
    void pass() {
        Direction direction = new Direction(false, false);

        assertThat(direction.move()).isEqualTo(0);
    }

    @Test
    void exception() {
        assertThatThrownBy(() -> new Direction(true, true))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void first() {
        assertThat(Direction.first(false).move()).isEqualTo(0);
        assertThat(Direction.first(true).move()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource({"false, true, 1", "true, false, -1", "false, false, 0"})
    void next(boolean left, boolean right, int expected) {
        assertThat(Direction.first(left).next(right).move()).isEqualTo(expected);
        assertThat(Direction.first(left).next(right).move()).isEqualTo(expected);
        assertThat(Direction.first(left).next(right).move()).isEqualTo(expected);
    }
}
