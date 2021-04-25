package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTwoTest {
    @Test
    public void first() {
        assertThat(PointTwo.first()).isNotEqualTo(new PointTwo(Direction.LEFT));
    }

    @Test
    public void next_When_DirectionIsNone() {
        final PointTwo point = new PointTwo(Direction.NONE);

        assertThat(point.next()).isNotEqualTo(new PointTwo(Direction.LEFT));
    }

    @Test
    public void next_When_DirectionIsRight() {
        final PointTwo point = new PointTwo(Direction.RIGHT);

        assertThat(point.next()).isEqualTo(new PointTwo(Direction.LEFT));
    }

    @Test
    public void next_When_DirectionIsLeft() {
        final PointTwo point = new PointTwo(Direction.LEFT);

        assertThat(point.next()).isNotEqualTo(new PointTwo(Direction.LEFT));
    }

    @Test
    public void last_When_DirectionIsNone() {
        final PointTwo point = new PointTwo(Direction.NONE);

        assertThat(point.last()).isEqualTo(new PointTwo(Direction.NONE));
    }

    @Test
    public void last_When_DirectionIsRight() {
        final PointTwo point = new PointTwo(Direction.RIGHT);

        assertThat(point.last()).isEqualTo(new PointTwo(Direction.LEFT));
    }

    @Test
    public void last_When_DirectionIsLeft() {
        final PointTwo point = new PointTwo(Direction.LEFT);

        assertThat(point.last()).isEqualTo(new PointTwo(Direction.NONE));
    }
}