package game.ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {

    @Test
    public void init() {
        assertThat(Direction.of(true, false)).isEqualTo(Direction.of(true, false));
    }

    @Test(expected = IllegalStateException.class)
    public void init_invalid() {
        Direction.of(true, true);
    }

    @Test
    public void next_random_true() {
        Direction next = Direction.first(true).next();
        assertThat(next).isEqualTo(Direction.of(true, false));

    }

    @Test
    public void next_true() {
        Direction next = Direction.of(true, false).next(true);
        assertThat(next).isEqualTo(Direction.of(false, true));
    }

    @Test
    public void next_false() {
        Direction next = Direction.of(false, true).next(false);
        assertThat(next).isEqualTo(Direction.of(true, false));
    }

    @Test
    public void first() {
        Direction first = Direction.first(true);
        assertThat(first.isLeft()).isFalse();
        assertThat(first.isRight()).isTrue();
    }

    @Test
    public void last() {
        Direction last = Direction.first(true).last();
        assertThat(last.isLeft()).isTrue();
        assertThat(last.isRight()).isFalse();
    }

}