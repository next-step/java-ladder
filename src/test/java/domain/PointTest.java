package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @Test(expected = IllegalArgumentException.class)
    public void _1미만값을_전달하면_예외가_발생한다() {
        Point.valueOf(0, false);
    }

    @Test
    public void 같은_위치와_이동가능여부를_가진_포인트는_같다() {
        Point point1 = Point.valueOf(1, true);
        Point point2 = Point.valueOf(1, true);

        assertThat(point1).isEqualTo(point2);
    }

    @Test
    public void 첫번째_포인트를_생성한다() {
        Point point = Point.first(true);
        assertThat(point).isEqualTo(Point.valueOf(1, true));
    }

    @Test
    public void 마지막_포인트를_생성한다() {
        Point point = Point.last(5);
        assertThat(point).isEqualTo(Point.valueOf(5, false));
    }

    @Test
    public void 다음_포인트를_생성한다() {
        Point creteria = Point.valueOf(1, true);
        assertThat(Point.next(creteria, true)).isEqualTo(Point.valueOf(2, false));
        assertThat(Point.next(creteria, false)).isEqualTo(Point.valueOf(2, false));
    }

    @Test
    public void name() {
    }
}
