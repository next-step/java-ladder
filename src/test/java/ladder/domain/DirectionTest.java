package ladder.domain;

import org.junit.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DirectionTest {

    @Test
    public void init() {
        assertThat(Direction.from(true, false), is(Direction.from(true, false)));
    }

    @Test(expected = IllegalStateException.class)
    public void init_invalid() {
        Direction.from(TRUE, TRUE);
    }

    @Test
    public void next_random_true() {
        Direction next = Direction.first(TRUE).next(Difficulty.MIDDLE);
        assertThat(next, is(Direction.from(TRUE, FALSE)));
    }

    @Test
    public void next_random_false() {
        for (int i = 0; i < 100; i++) {
            Direction.first(FALSE).next(Difficulty.MIDDLE);
        }
    }

    @Test
    public void next_true() {
        Direction next = Direction.from(TRUE, FALSE).next(TRUE);
        assertThat(next, is(Direction.from(FALSE, TRUE)));
    }

    @Test
    public void next_false() {
        Direction next = Direction.from(FALSE, TRUE).next(FALSE);
        assertThat(next, is(Direction.from(TRUE, FALSE)));
    }

    @Test
    public void first() {
        Direction first = Direction.first(TRUE);
        assertThat(first.isLeft(), is(FALSE));
    }

    @Test
    public void last() {
        Direction last = Direction.first(TRUE).last();
        assertThat(last, is(Direction.from(TRUE, FALSE)));
    }
}
