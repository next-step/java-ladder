package ladder.domain;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PointTest {
    private Point point;

    @Test
    public void 포인트가_겹친다() {
        assertTrue(Point.isTrueOverlap(new Point(true), new Point(true)));
    }

    @Test
    public void 포인트가_겹치지_않는다() {
        assertFalse(Point.isTrueOverlap(new Point(true), new Point(false)));
        assertFalse(Point.isTrueOverlap(new Point(false), new Point(true)));
        assertFalse(Point.isTrueOverlap(new Point(false), new Point(false)));
    }

    @Test
    public void 포인트_반대값_반환() {
        point = Point.generateRandom();
        Point reversePoint = Point.reverse(point);
        assertFalse(point.equals(reversePoint));
    }

    @Test
    public void 라인을_그리지_않는다() {
        point = new Point(false);
        assertThat(point.toString()).isEqualTo("     ");
    }

    @Test
    public void 라인을_그린다() {
        point = new Point(true);
        assertThat(point.toString()).isEqualTo("-----");
    }
}
