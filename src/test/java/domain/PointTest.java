package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @Test(expected = IllegalArgumentException.class)
    public void _1미만값을_전달하면_예외가_발생한다() {
        Point.valueOf(0, false);
    }

    @Test
    public void 포인트가_이동불가하면_다음포인트는_이동가능하다() {
        Point point = Point.valueOf(1, false);
        Point nextPoint = point.next(true);

        assertThat(nextPoint.isMovable()).isTrue();
    }

    @Test
    public void 이동여부_상관없이_같은_좌표를_가진_포인트는_같다() {
        Point point1 = Point.valueOf(1, false);
        Point point2 = Point.valueOf(1, true);

        assertThat(point1).isEqualTo(point2);
    }
}
