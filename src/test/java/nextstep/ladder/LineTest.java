package nextstep.ladder;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LineTest {

    @Test
    void newLine_trueStrategy() {
        Line line = new Line(4, () -> true);
        List<Boolean> points = line.getPoints();

        assertEquals(points.size(), 3); // 크기 검증

        // 사다리가 겹치지 않도록 생성
        // 패턴: [true, false, true]
        assertTrue(points.get(0));
        assertFalse(points.get(1));
        assertTrue(points.get(2));
    }

    @Test
    void newLine_falseStrategy() {
        Line line = new Line(4, () -> false);
        List<Boolean> points = line.getPoints();

        assertEquals(points.size(), 3);
        assertAll("모든 포인트는 false",
                () -> assertFalse(points.get(0)),
                () -> assertFalse(points.get(1)),
                () -> assertFalse(points.get(2))
        );
    }

}
