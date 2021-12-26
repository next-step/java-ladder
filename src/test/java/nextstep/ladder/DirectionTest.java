package nextstep.ladder;

import nextstep.ladder.domain.Direction;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DirectionTest {

    @Test
    public void init() {
        assertThat(Direction.of(true, false), is(Direction.of(true, false)));
    }

    @Test(expected = IllegalStateException.class)
    public void init_invalid() {
        Direction.of(true, true);
    }

    @Test
    public void next_random_true() {
        Direction next = Direction.first(true).next();
        assertThat(next, is(Direction.of(true, false)));
    }
    @Test
    public void next_random_false() {
        for (int i = 0; i < 100; i++) {
            Direction.first(false).next();
        }
    }
    @Test
    public void next_true() {
        Direction next = Direction.of(false, true).next();
        assertThat(next, is(Direction.of(true, false)));
    }

    @Test
    public void first() {
        Direction first = Direction.first(true);
        assertThat(first.isLeft(), is(false));
    }

    @Test
    public void last() {
        Direction last = Direction.first(true).last();
        assertThat(last, is(Direction.of(true, false)));
    }
}
