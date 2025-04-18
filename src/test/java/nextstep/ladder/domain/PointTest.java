package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void 오른쪽_연결_정보를_정확히_반환한다() {
        Point point = new Point(true);
        assertTrue(point.hasRight());

        Point noRight = new Point(false);
        assertFalse(noRight.hasRight());
    }

    @Test
    void 연속된_가로줄은_생기지_않아야_한다() {
        Point first = new Point(true);
        Point next = first.next(true);
        assertFalse(next.hasRight(), "앞이 true면 연속으로 true가 나오면 안됨");
    }
}
