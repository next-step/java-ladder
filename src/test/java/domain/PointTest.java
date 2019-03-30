package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @Test
    public void 같은_좌표를_가진_포인트는_같다() {
        Point point1 = Point.of(1,1);
        Point point2 = Point.of(1,1);

        assertThat(point1).isEqualTo(point2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void _0이하값을_전달하면_예외가_발생한다() {
        Point.of(0, 2);
    }

    @Test
    public void 좌표간의_x축_거리를_잰다() {
        assertThat(Point.of(1,1).distanceOfX(Point.of(2,1))).isEqualTo(1);
        assertThat(Point.of(1,1).distanceOfX(Point.of(3,1))).isEqualTo(2);
    }

    @Test
    public void 좌표간의_y축_거리를_잰다() {
        assertThat(Point.of(1,1).distanceOfY(Point.of(1,2))).isEqualTo(1);
        assertThat(Point.of(1,1).distanceOfY(Point.of(1,3))).isEqualTo(2);
    }

    @Test
    public void x축을_1_증가한다() {
        assertThat(Point.of(1, 1).increaseX()).isEqualTo(Point.of(2, 1));
    }

    @Test
    public void y축을_1_증가한다() {
        assertThat(Point.of(1, 1).increaseY()).isEqualTo(Point.of(1, 2));
    }
}
