package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CrossTest {
    @Test
    @DisplayName("right로 이동하면 위치가 1 증가한다.")
    void rightTest() {
        Cross cross = new Cross(1, Point.first(false).next(true));
        assertEquals(cross.move(), 2);
    }

    @Test
    @DisplayName("left로 이동하면 위치가 1 감소한다.")
    void leftTest() {
        Cross cross = new Cross(1, Point.first(true).next(false));
        assertEquals(cross.move(), 0);
    }

    @Test
    @DisplayName("stay이면 위치에 변화가 없다.")
    void stayTest() {
        Cross cross = new Cross(1, Point.first(false).next(false));
        assertEquals(cross.move(), 1);
    }

}
