package nextstep.ladder.domain;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    void 포인트_개수는_플레이어_수와_같아야_한다() {
        int count = 4;
        Line line = new Line(count);
        assertEquals(count, line.getPoints().size());
    }

    @RepeatedTest(10) // 랜덤성 때문에 반복
    void 연속된_가로줄이_생기지_않는다() {
        Line line = new Line(10);
        List<Point> points = line.getPoints();
        for (int i = 0; i < points.size() - 2; i++) {
            if (points.get(i).hasRight()) {
                assertFalse(points.get(i + 1).hasRight(), "가로줄이 연속으로 연결되면 안됨");
            }
        }
    }
}

