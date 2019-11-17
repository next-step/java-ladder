package nextstep.ladder;

import nextstep.ladder.domain.Point;
import nextstep.ladder.domain.Points;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PointsTest {

    /**
     * |-----|
     * */
    @Test
    void pointsMoveTest() {
        List<Point> totalPoint = new ArrayList<>();

        Point firstPoint = new Point(0, true, null);
        Point secondPoint = new Point(1, false, firstPoint);

        totalPoint.add(firstPoint);
        totalPoint.add(secondPoint);
        Points points = new Points(totalPoint);

        assertThat(points.move(0)).isEqualTo(1);
        assertThat(points.move(1)).isEqualTo(0);
    }

    /**
     * |     |
     * */
    @Test
    void pointsMoveTest2() {
        List<Point> totalPoint = new ArrayList<>();

        Point firstPoint = new Point(0, false, null);
        Point secondPoint = new Point(1, false, firstPoint);

        totalPoint.add(firstPoint);
        totalPoint.add(secondPoint);
        Points points = new Points(totalPoint);

        assertThat(points.move(0)).isEqualTo(0);
        assertThat(points.move(1)).isEqualTo(1);
    }
}
