package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    @DisplayName("라인 생성")
    void create() {
        Point point1 = new Point(new Position(0), new Direction(false, true));
        Point point2 = new Point(new Position(1), new Direction(false, false));
        Point point3 = new Point(new Position(2), new Direction(false, true));
        Point point4 = new Point(new Position(3), new Direction(false, false));
        List<Point> points = Arrays.asList(point1, point2, point3, point4);
        Line line = new Line(points);
        assertThat(line).isEqualTo(new Line(points));
        assertThat(line.getPoints()).size().isEqualTo(4);
    }

    @Test
    @DisplayName("포인트 생성하여 라인객체 생성")
    void firstPoint() {
        Line line = Line.createLine(4);
        assertThat(line.getPoints()).size().isEqualTo(4);
    }

}