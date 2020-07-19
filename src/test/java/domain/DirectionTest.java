package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {

    @Test
    void 왼쪽과_오른쪽이_둘다_True이면_안된다() {
        assertThrows(IllegalArgumentException.class, () -> Direction.of(true, true));
    }

    @Test
    void 마지막_포인트는_오른쪽이_FALSE다() {
        Direction direction = Direction.of(true, false);

        Direction last = direction.last();
        assertEquals(last, Direction.of(false, false));
    }

    @Test
    void 첫번쨰_포인트는_왼쪽이_FALSE다() {
        Direction first1 = Direction.first(true);
        Direction first2 = Direction.first(false);

        assertEquals(first1, Direction.of(false, true));
        assertEquals(first2, Direction.of(false, false));
    }

    @Test
    void 앞이_연결되면_다음은_false다() {
        Direction direction = Direction.of(false, true);
        Direction next = direction.next(LadderLevel.HIGH);

        assertEquals(next, Direction.of(true, false));
    }

    @Test
    void 왼쪽과_오른쪽을_알려준다() {
        Direction direction = Direction.of(true, false);

        assertTrue(direction.isLeft());
        assertFalse(direction.isRight());
    }
}