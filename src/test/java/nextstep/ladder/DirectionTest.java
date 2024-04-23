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
        Direction firstFalseTrue = Direction.first(true);
        Direction firstFalseFalse = Direction.first(false);

        assertThat(firstFalseTrue).isEqualTo(Direction.of(false, true));
        assertThat(firstFalseFalse).isEqualTo(Direction.of(false, false));
    }

    @Test
    void last() {
        Direction last = Direction.first(true).next(false).last();

        assertThat(last).isEqualTo(Direction.of(false, false));
    }
}
