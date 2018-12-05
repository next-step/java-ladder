package dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    public void 포인트_First_생성테스트() {
        assertThat(Point.isFirst().direction).isNotEqualByComparingTo(Direction.LEFT);
    }

    @Test
    public void 포인트_Last_생성테스트() {
        Point point = new Point(5,Direction.LEFT);
        assertThat(Point.isLast(point).direction).isNotEqualByComparingTo(Direction.RIGHT);
    }



}
