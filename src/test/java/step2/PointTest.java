package step2;

import org.junit.jupiter.api.Test;
import step2.model.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PointTest {
    @Test
    public void 첫번째_포인트_생성() {
        assertThat(Point.first(() -> true)).isEqualTo(new Point(false, true));
    }

    @Test
    public void 중간_포인트들_생성() {
        //given
        List<Point> pointList = new ArrayList<>();
        pointList.add(Point.first(() -> true));

        Point first = new Point(false, true);
        Point second = new Point(true, false);
        Point third = new Point(false, true);

        //when
        Point.middle(pointList, 3, () -> true);

        //then
        assertThat(pointList).isEqualTo(Arrays.asList(first, second, third));
    }

    @Test
    public void 마지막_포인트_생성() {
        //given
        Point first = new Point(false, true);
        Point second = new Point(true, false);
        Point third = new Point(false, true);

        List<Point> pointList = Arrays.asList(first, second, third);

        assertThat(Point.last(pointList)).isEqualTo(new Point(true, false));
    }

    @Test
    public void 포인트_전체_생성() {
        //given
        Point first = new Point(false, true);
        Point second = new Point(true, false);
        Point third = new Point(false, true);
        Point fourth = new Point(true, false);

        List<Point> expect = Arrays.asList(first, second, third, fourth);

        //when
        List<Point> actual = Point.generatePoints(4, () -> true);

        //then
        assertThat(actual).isEqualTo(expect);
    }
}
