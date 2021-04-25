package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @Test
    public void first() {
        assertThat(Point.first()).isNotEqualTo(new Point(Direction.LEFT));
    }

    @Test
    public void next_When_DirectionIsNone() {
        final Point point = new Point(Direction.NONE);

        assertThat(point.next()).isNotEqualTo(new Point(Direction.LEFT));
    }

    @Test
    public void next_When_DirectionIsRight() {
        final Point point = new Point(Direction.RIGHT);

        assertThat(point.next()).isEqualTo(new Point(Direction.LEFT));
    }

    @Test
    public void next_When_DirectionIsLeft() {
        final Point point = new Point(Direction.LEFT);

        assertThat(point.next()).isNotEqualTo(new Point(Direction.LEFT));
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