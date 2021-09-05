package step2;

import org.junit.jupiter.api.Test;
import step2.model.Point;
import step2.model.Points;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PointsTest {
    @Test
    public void 첫번째_포인트_생성() {
        assertThat(Points.first(() -> true)).isEqualTo(new Point(false, true));
    }

    @Test
    public void 중간_포인트들_생성() {
        //given
        Point first = new Point(false, true);
        Point second = new Point(true, false);
        Point third = new Point(false, true);
        Points expect = new Points(Arrays.asList(first, second, third));

        List<Point> pointList = new ArrayList<>();
        pointList.add(Points.first(() -> true));

        //when
        Points.middle(pointList, 4, () -> true);
        Points actual = new Points(pointList);

        //then
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    public void 마지막_포인트_생성() {
        //given
        Point first = new Point(false, true);
        Point second = new Point(true, false);
        Point third = new Point(false, true);

        List<Point> pointList = Arrays.asList(first, second, third);

        //when
        Point last = Points.last(pointList);

        //then
        assertThat(last).isEqualTo(new Point(true, false));
    }

    @Test
    public void 포인트_전체_생성() {
        //given
        Point first = new Point(false, true);
        Point second = new Point(true, false);
        Point third = new Point(false, true);
        Point fourth = new Point(true, false);

        Points expect = new Points(Arrays.asList(first, second, third, fourth));

        //when
        Points actual = new Points(4, () -> true);

        //then
        assertThat(actual).isEqualTo(expect);
    }
}
