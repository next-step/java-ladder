package ladder.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    private List<Point> points;
    private List<Point> secondPoints;

    @Before
    public void setUp() throws Exception {
        Point point1 = new Point(false, true);
        Point point2 = new Point(true, false);
        Point point3 = new Point(false, false);
        points = new ArrayList<>();
        secondPoints = new ArrayList<>();

        points.add(point1);
        points.add(point2);
        points.add(point3);

        secondPoints.add(point2);
        secondPoints.add(point3);
        secondPoints.add(point1);
    }

    @Test
    public void 라인생성() {
        Line line = new Line(points);
        assertThat(line.lineCount()).isEqualTo(3);
    }

    @Test
    public void 가로라인존재() {
        Line line = new Line(points);
        boolean result = line.hasHorizontalLine(0);
        assertThat(result).isTrue();
    }

    @Test
    public void 가로라인미존재() {
        Line line = new Line(points);
        boolean result = line.hasHorizontalLine(1);
        assertThat(result).isFalse();
    }
}