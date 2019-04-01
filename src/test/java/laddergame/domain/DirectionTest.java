package laddergame.domain;

import laddergame.service.LadderRandomValueGenerator;
import org.junit.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.junit.Assert.assertEquals;

public class DirectionTest {
    @Test
    public void init() {
        assertEquals(Direction.of(true, false), Direction.of(true, false));
    }

    @Test(expected = IllegalStateException.class)
    public void init_invalid() {
        Direction.of(TRUE, TRUE);
    }

    @Test
    public void next_random_true() {
        Direction next = Direction.first(TRUE).next(LadderRandomValueGenerator.getInstance());
        assertEquals(next, Direction.of(TRUE, FALSE));
    }

    @Test
    public void next_random_false() {
        Direction next = Direction.first(FALSE).next(LadderRandomValueGenerator.getInstance());
        assertEquals(next.isToLeft(), FALSE);
    }

    @Test
    public void next_true() {
        Direction next = Direction.of(TRUE, FALSE).next(TRUE);
        assertEquals(next, Direction.of(FALSE, TRUE));
    }

    @Test
    public void next_false() {
        Direction next = Direction.of(FALSE, TRUE).next(FALSE);
        assertEquals(next, Direction.of(TRUE, FALSE));
    }

    @Test
    public void first() {
        Direction first = Direction.first(TRUE);
        assertEquals(first.isToLeft(), FALSE);
    }

    @Test
    public void last() {
        Direction last = Direction.first(TRUE).last();
        assertEquals(last, Direction.of(TRUE, FALSE));
    }
}