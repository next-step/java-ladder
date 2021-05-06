package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @Test
    public void move_When_DirectionIsNone() {
        final Point point = new Point(1, Direction.NONE);

        assertThat(point.move()).isEqualTo(1);
    }

    @Test
    public void move_When_DirectionIsRight() {
        final Point point = new Point(1, Direction.RIGHT);

        assertThat(point.move()).isEqualTo(2);
    }

    @Test
    public void move_When_DirectionIsLeft() {
        final Point point = new Point(1, Direction.LEFT);

        assertThat(point.move()).isEqualTo(0);
    }
}