package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.Point;

import static org.junit.jupiter.api.Assertions.*;
import static java.lang.Boolean.TRUE;
import static java.lang.Boolean.FALSE;

class PointTest {

    @DisplayName("사다리 한쪽방향이 true일 경우 이동 테스트")
    @Test
    void first() {
        assertEquals(Point.first(TRUE).move(), 1);
        assertEquals(Point.first(FALSE).move(), 0);
    }

    @DisplayName("사다리 양방향이 false일 경우 테스트")
    @Test
    void next_stay() {
        Point second = Point.first(FALSE).next(FALSE);
        assertEquals(second.move(), 1);
    }

    @DisplayName("사다리 뒤쪽이 true일 경우 테스트")
    @Test
    void next_left() {
        Point second = Point.first(TRUE).next(FALSE);
        assertEquals(second.move(), 0);
    }

    @DisplayName("사다리 앞쪽이 true일 경우 테스트")
    @Test
    void next_right() {
        Point second = Point.first(FALSE).next(TRUE);
        assertEquals(second.move(), 2);
    }

    @DisplayName("사다리 양방향이 true일 경우 테스트")
    @Test
    void next() {
        Point second = Point.first(TRUE).next(new LadderPointGenerator());
        assertEquals(second.move(), 0);
    }

}