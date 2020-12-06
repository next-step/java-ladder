package nextstep.ladder.entity.ladder;

import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DirectionTest {

    @Test
    public void init() {
        assertEquals(Direction.of(true, false), Direction.of(true, false));
    }

    @Test
    public void init_invalid() {
        assertThrows(IllegalStateException.class, () -> Direction.of(TRUE, TRUE));
    }

    @Test
    public void next_random_true() {
        Direction next = Direction.first(TRUE).next();
        assertEquals(next, Direction.of(TRUE, FALSE));
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
        assertEquals(first.isLeft(), FALSE);
    }

    @Test
    public void last() {
        Direction last = Direction.first(TRUE).last();
        assertEquals(last, Direction.of(TRUE, FALSE));
    }
}