package ladder2.model;

import org.junit.Test;

import static ladder2.util.DefaultLadderPointGeneratorTest.DEFAULT_LADDER_POINT_GENERATOR;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class PointTest {
    @Test
    public void 이동_시작지점에서() {
        assertThat(Point.first(true).move()).isEqualTo(1);
        assertThat(Point.first(false).move()).isEqualTo(0);
    }

    @Test
    public void 이동_두번째지점에서() {
        Point nextPoint = Point.first(true).next(DEFAULT_LADDER_POINT_GENERATOR);
        assertThat(nextPoint.move()).isEqualTo(0);
    }

    @Test
    public void 이동_마지막지점에서() {
        Point last = Point.first(true).last();
        assertThat(last.move()).isEqualTo(0);
    }

    @Test
    public void 이동_오른쪽으로() {
        Point nextPoint = Point.first(false).next(true);
        assertThat(nextPoint.move()).isEqualTo(2);
    }

    @Test
    public void 이동_아래쪽으로() {
        Point nextPoint = Point.first(false).next(false);
        assertThat(nextPoint.move()).isEqualTo(1);
    }
}