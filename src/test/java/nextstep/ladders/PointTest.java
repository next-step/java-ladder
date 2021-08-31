package nextstep.ladders;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PointTest {

    @Test
    void 정상_생성() {
        Point expected = new Point(0, Direction.of(true, false));
        Point actual = new Point(0, Direction.of(true, false));
        assertEquals(expected, actual);
    }

    @Test
    void 오른쪽에_길이있으면_위치증가() {
        Point point = new Point(0, Direction.of(false, true));
        assertEquals(point.move(), 1);
    }

    @Test
    void 왼쪽에_길이있으면_위치증가() {
        Point point = new Point(2, Direction.of(true, false));
        assertEquals(point.move(), 1);
    }
}
