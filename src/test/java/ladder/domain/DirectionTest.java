package ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {
    @ParameterizedTest
    @CsvSource(value = {"true:RIGHT", "false:NONE"}, delimiter = ':')
    public void first(final String isRightInput, final String directionInput) {
        final boolean isRight = Boolean.parseBoolean(isRightInput);
        final Direction direction = Direction.valueOf(directionInput);

        assertThat(Direction.first(() -> isRight)).isEqualTo(direction);
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    public void next_When_DirectionIsNone(boolean isRight) {
        final Direction next = Direction.NONE.next(() -> isRight);

        assertThat(next).isNotEqualTo(Direction.LEFT);
    }


    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    public void next_When_DirectionIsRight(boolean isRight) {
        final Direction next = Direction.RIGHT.next(() -> isRight);

        assertThat(next).isEqualTo(Direction.LEFT);
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    public void next_When_DirectionIsLeft(boolean isRight) {
        final Direction next = Direction.LEFT.next(() -> isRight);

        assertThat(next).isNotEqualTo(Direction.LEFT);
    }

    @Test
    public void last_When_DirectionIsNone() {
        final Direction last = Direction.LEFT.last();

        assertThat(last).isEqualTo(Direction.NONE);
    }

    @Test
    public void last_When_DirectionIsRight() {
        final Direction last = Direction.RIGHT.last();

        assertThat(last).isEqualTo(Direction.LEFT);
    }

    @Test
    public void last_When_DirectionIsLeft() {
        final Direction last = Direction.LEFT.last();

        assertThat(last).isEqualTo(Direction.NONE);
    }
}
