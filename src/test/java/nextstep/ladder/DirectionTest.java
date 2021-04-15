package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DirectionTest {
    @Test
    void test() {
        assertThat(Direction.of(true, false), is(Direction.of(true, false)));
    }

    @Test
    public void init_invalid() {
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> Direction.of(TRUE, TRUE));
    }

    @Test
    public void next_random_true() {
        Direction next = Direction.first(TRUE).next();
        assertThat(next, is(Direction.of(TRUE, FALSE)));
    }

    @Test
    public void next_random_false() {
        for (int i = 0; i < 100; i++) {
            Direction.first(FALSE).next();
        }
    }

    @Test
    public void next_true() {
        Direction next = Direction.of(TRUE, FALSE).next(TRUE);
        assertThat(next, is(Direction.of(FALSE, TRUE)));
    }

    @Test
    public void next_false() {
        Direction next = Direction.of(FALSE, TRUE).next(FALSE);
        assertThat(next, is(Direction.of(TRUE, FALSE)));
    }

    @Test
    public void first() {
        Direction first = Direction.first(TRUE);
        assertThat(first.isLeft(), is(FALSE));
    }

    @Test
    public void last() {
        Direction last = Direction.first(TRUE).last();
        assertThat(last, is(Direction.of(TRUE, FALSE)));
    }
}
