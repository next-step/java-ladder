package domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @Test
    public void 같은_좌표를_가진_포인트는_같다() {
        Point point1 = Point.valueOf(1,1);
        Point point2 = Point.valueOf(1,1);

        assertThat(point1).isEqualTo(point2);
    }

    @Test
    public void x_y_순서로_정렬한다() {
        List<Point> points = new ArrayList<>();
        points.add(Point.valueOf(2, 2));
        points.add(Point.valueOf(3, 2));
        points.add(Point.valueOf(1, 1));
        points.add(Point.valueOf(1, 2));
        points.add(Point.valueOf(2, 1));
        points.add(Point.valueOf(3, 1));

        /**
         * 1,1 2,1 3,1
         * 1,2 2,2 3,2
         */
        points = points.stream().sorted().collect(Collectors.toList());
        assertThat(points.get(0)).isEqualTo(Point.valueOf(1, 1));
        assertThat(points.get(1)).isEqualTo(Point.valueOf(2, 1));
        assertThat(points.get(2)).isEqualTo(Point.valueOf(3, 1));
        assertThat(points.get(3)).isEqualTo(Point.valueOf(1, 2));
        assertThat(points.get(4)).isEqualTo(Point.valueOf(2, 2));
        assertThat(points.get(5)).isEqualTo(Point.valueOf(3, 2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void _0이하값을_전달하면_예외가_발생한다() {
        Point.valueOf(0, 2);
    }

    @Test
    public void 좌표간의_x축_거리를_잰다() {
        assertThat(Point.valueOf(1,1).distanceOfX(Point.valueOf(2,1))).isEqualTo(1);
        assertThat(Point.valueOf(1,1).distanceOfX(Point.valueOf(3,1))).isEqualTo(2);
    }

    @Test
    public void 좌표간의_y축_거리를_잰다() {
        assertThat(Point.valueOf(1,1).distanceOfY(Point.valueOf(1,2))).isEqualTo(1);
        assertThat(Point.valueOf(1,1).distanceOfY(Point.valueOf(1,3))).isEqualTo(2);
    }

    @Test
    public void x축을_1_증가한다() {
        assertThat(Point.valueOf(1, 1).increaseX()).isEqualTo(Point.valueOf(2, 1));
    }

    @Test
    public void y축을_1_증가한다() {
        assertThat(Point.valueOf(1, 1).increaseY()).isEqualTo(Point.valueOf(1, 2));
    }

    @Test
    public void NxM_포인트를_반환한다() {
        assertThat(Point.valuesOf(5, 6)).hasSize(30);
    }
}
