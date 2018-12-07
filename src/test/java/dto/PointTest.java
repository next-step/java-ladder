package dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    public void 포인트_First_생성테스트() {
        assertThat(Point.isFirst(Difficulty.NORMAL).getDirection()).isNotEqualByComparingTo(Direction.LEFT);
    }

    @Test
    public void 포인트_Last_생성테스트() {
        Point point = new Point(5,Direction.LEFT);
        assertThat(Point.isLast(point).getDirection()).isNotEqualByComparingTo(Direction.RIGHT);
    }

    @Test
    public void 오른쪽이동() {
        Point point = new Point(5,Direction.LEFT);
        assertThat(point.move()).isEqualTo(4);
    }

    @Test
    public void 왼쪽이동() {
        Point point = new Point(5,Direction.RIGHT);
        assertThat(point.move()).isEqualTo(6);
    }

    @Test
    public void 이동없음() {
        Point point = new Point(5,Direction.BOTTOM);
        assertThat(point.move()).isEqualTo(5);
    }
}
