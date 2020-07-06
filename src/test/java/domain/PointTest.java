package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PointTest {

    @Test
    void 왼쪽과_오른쪽이_둘다_True이면_안된다() {
        assertThrows(IllegalArgumentException.class, () -> Point.of(true, true));
    }

    @Test
    void 마지막_포인트는_오른쪽이_FALSE다() {
        Point point = Point.of(true, false);

        Point last = point.last();
        assertEquals(last, Point.of(false, false));
    }

    @Test
    void 첫번쨰_포인트는_왼쪽이_FALSE다() {
        Point first = Point.first(true);

        assertEquals(first, Point.of(false, true));
    }
}