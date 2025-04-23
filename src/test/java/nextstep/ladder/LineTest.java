package nextstep.ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LineTest {

    Line line;
    Line falseLine;

    @BeforeEach
    void setUp() {
        // 4명의 참가자 (points 크기 3)
        // 고정된 가로줄 패턴: [true, false, true]
        line = new Line(4, () -> true);

        // 모든 point가 false
        falseLine = new Line(4, () -> false);
    }

    @Test
    void newLine_trueStrategy() {
        List<Boolean> points = line.getPoints();

        assertEquals(points.size(), 3);
        assertTrue(points.get(0));
        assertFalse(points.get(1));
        assertTrue(points.get(2));
    }

    @Test
    void newLine_falseStrategy() {
        falseLine = new Line(4, () -> false);
        List<Boolean> points = falseLine.getPoints();

        assertEquals(points.size(), 3);
        assertAll("모든 포인트는 false",
                () -> assertFalse(points.get(0)),
                () -> assertFalse(points.get(1)),
                () -> assertFalse(points.get(2))
        );
    }


    @Test
    void 오른쪽_이동() {
        assertEquals(1, line.move(0));
        assertEquals(3, line.move(2));

    }

    @Test
    void 왼쪽_이동() {
        assertEquals(0, line.move(1));
        assertEquals(2, line.move(3));

    }


    @Test
    void 이동_안함() {
        assertEquals(1, falseLine.move(1));
    }

    @Test
    void 이동_위치는_0보다큰수() {
        assertThrows(IllegalArgumentException.class, () -> line.move(-1));
    }

    @Test
    void 이동_위치는_참가자보다작은수() {
        assertThrows(IllegalArgumentException.class, () -> line.move(4));
    }
}
