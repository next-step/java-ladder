package laddergame.domain;

import laddergame.service.LadderRandomValueGenerator;
import org.junit.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {
    @Test
    public void init() {
        assertThat(Direction.of(true, false)).isEqualTo(Direction.of(true, false));
    }

    @Test(expected = IllegalStateException.class)
    public void init_invalid() {
        Direction.of(TRUE, TRUE);
    }

    @Test
    public void next_random_true() {
        Direction next = Direction.first(TRUE).next(LadderRandomValueGenerator.getInstance());
        assertThat(next).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @Test
    public void next_random_false() {
        Direction next = Direction.first(FALSE).next(LadderRandomValueGenerator.getInstance());
        assertThat(next.isToLeft()).isEqualTo(FALSE);
    }

    @Test
    public void next_true() {
        Direction next = Direction.of(TRUE, FALSE).next(TRUE);
        assertThat(next).isEqualTo(Direction.of(FALSE, TRUE));
    }

    @Test
    public void next_false() {
        Direction next = Direction.of(FALSE, TRUE).next(FALSE);
        assertThat(next).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @Test
    public void first() {
        Direction first = Direction.first(TRUE);
        assertThat(first.isToLeft()).isEqualTo(FALSE);
    }

    @Test
    public void last() {
        Direction last = Direction.first(TRUE).last();
        assertThat(last).isEqualTo(Direction.of(TRUE, FALSE));
    }
}