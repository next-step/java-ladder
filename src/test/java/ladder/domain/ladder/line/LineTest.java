package ladder.domain.ladder.line;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.ladder.point.Point;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    void permute_switch() {
        List<Point> points = new ArrayList<>();
        Point point = Point.first(true);
        points.add(point);
        point = point.last();
        points.add(point);

        Line line = Line.of(points);

        assertThat(line.permute(0)).isEqualTo(1);
        assertThat(line.permute(1)).isZero();
    }

    @Test
    void permute_identity() {
        List<Point> points = new ArrayList<>();
        Point point = Point.first(false);
        points.add(point);
        point = point.last();
        points.add(point);

        Line line = Line.of(points);

        assertThat(line.permute(0)).isZero();
        assertThat(line.permute(1)).isEqualTo(1);
    }
}
