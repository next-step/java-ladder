package ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @ParameterizedTest
    @CsvSource(value = {"true:RIGHT", "false:NONE"}, delimiter = ':')
    public void first(String isRightInput, String directionInput) {
        final boolean isRight = Boolean.parseBoolean(isRightInput);
        final Direction direction = Direction.valueOf(directionInput);

        assertThat(Point.first(() -> isRight)).isEqualTo(new Point(direction));
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    public void next_When_DirectionIsNone(boolean isRight) {
        final Point point = new Point(Direction.NONE);

        assertThat(point.next(() -> isRight)).isNotEqualTo(new Point(Direction.LEFT));
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    public void next_When_DirectionIsRight(boolean isRight) {
        final Point point = new Point(Direction.RIGHT);

        assertThat(point.next(() -> isRight)).isEqualTo(new Point(Direction.LEFT));
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    public void next_When_DirectionIsLeft(boolean isRight) {
        final Point point = new Point(Direction.LEFT);

        assertThat(point.next(() -> isRight)).isNotEqualTo(new Point(Direction.LEFT));
    }

    @Test
    public void last_When_DirectionIsNone() {
        final Point point = new Point(Direction.NONE);

        assertThat(point.last()).isEqualTo(new Point(Direction.NONE));
    }

    @Test
    public void last_When_DirectionIsRight() {
        final Point point = new Point(Direction.RIGHT);

        assertThat(point.last()).isEqualTo(new Point(Direction.LEFT));
    }

    @Test
    public void last_When_DirectionIsLeft() {
        final Point point = new Point(Direction.LEFT);

        assertThat(point.last()).isEqualTo(new Point(Direction.NONE));
    }
}