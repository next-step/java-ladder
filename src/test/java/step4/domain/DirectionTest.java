package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.Direction;

import static java.lang.Boolean.TRUE;
import static java.lang.Boolean.FALSE;
import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {

    @DisplayName("Direction 생성 테스트")
    @Test
    void init() {
        assertEquals(Direction.of(TRUE, FALSE), Direction.of(TRUE, FALSE));
    }

    @DisplayName("Direction 생성 실패 테스트")
    @Test
    void init_invalid() {
        assertThrows(IllegalStateException.class, () -> Direction.of(TRUE, TRUE));
    }

    @DisplayName("Direction 양방향이 True가 안되는 테스트")
    @Test
    void next_random_true() {

        Direction next = Direction.first(TRUE).next(new LadderPointGenerator());

        assertEquals(next, Direction.of(TRUE, FALSE));
    }

    @DisplayName("Direction 시작이 false일 경우 다음 next 생성 테스트")
    @Test
    void next_random_false() {
        for (int i = 0; i < 100; i++) {
            Direction next = Direction.first(FALSE).next(new LadderTestPointGenerator());

            assertEquals(next, Direction.of(FALSE, TRUE));
        }
    }

    @DisplayName("Direction next가 true일 경우 테스트")
    @Test
    void next_true() {
        Direction next = Direction.of(TRUE, FALSE).next(TRUE);
        assertEquals(next, Direction.of(FALSE, TRUE));
    }

    @DisplayName("Direction next가 false일 경우 테스트")
    @Test
    void next_false() {
        Direction next = Direction.of(FALSE, TRUE).next(FALSE);
        assertEquals(next, Direction.of(TRUE, FALSE));
    }

    @DisplayName("Direction 시작의 왼쪽은 false 테스트")
    @Test
    void first() {
        Direction first = Direction.first(TRUE);
        assertEquals(first.isLeft(), FALSE);
    }

    @DisplayName("Direction 마지막의 오른쪽은 false 테스트")
    @Test
    void last() {
        Direction last = Direction.first(TRUE).last();
        assertEquals(last, Direction.of(TRUE, FALSE));
    }
}