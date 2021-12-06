package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    @DisplayName("라인 생성")
    void create() {
        Point point1 = new Point(new Position(0), false, true);
        Point point2 = new Point(new Position(1), false, false);
        Point point3 = new Point(new Position(2), false, true);
        Point point4 = new Point(new Position(3), false, false);
        Point point5 = new Point(new Position(0), false, false);
        Point point6 = new Point(new Position(1), false, true);
        Point point7 = new Point(new Position(2), false, false);
        Point point8 = new Point(new Position(3), true, false);
        List<Point> points = Arrays.asList(point1, point2, point3, point4,
                point5, point6, point7, point8);
        Line line = new Line(points);
        assertThat(line).isEqualTo(new Line(points));
    }

}