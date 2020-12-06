package nextstep.ladder.entity.ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.junit.jupiter.api.Assertions.*;

public class PointTest {
    @Test
    public void first() {
        assertEquals(Point.first(TRUE).move(), 1);
        assertEquals(Point.first(FALSE).move(), 0);
    }

    @Test
    public void next_stay() {
        Point second = Point.first(FALSE).next(FALSE);
        assertEquals(second.move(), 1);
    }

    @Test
    public void next_left() {
        Point second = Point.first(TRUE).next(FALSE);
        assertEquals(second.move(), 0);
    }

    @Test
    public void next_right() {
        Point second = Point.first(FALSE).next(TRUE);
        assertEquals(second.move(), 2);
    }

    @Test
    public void next() {
        Point second = Point.first(TRUE).next();
        assertEquals(second.move(), 0);
    }
}