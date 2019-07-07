package ladder;

import ladder.domain.Line;
import ladder.domain.Point;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    void create() {
        Point first = Point.first(true);
        Point next = first.next(false);
        List<Point> points = Arrays.asList(first, next, next.next(false));
        assertThat(new Line(points).move(0)).isEqualTo(1);
    }

    @Test
    void move_pass() {
        Line line = new Line(Arrays.asList(Point.first(false)));
        assertThat(line.move(0)).isEqualTo(0);
    }

    @Test
    void move_right() {
        Line line = new Line(Arrays.asList(Point.first(true)));
        assertThat(line.move(0)).isEqualTo(1);
    }

    @Test
    void move_left() {
        Point first = Point.first(true);
        Line line = new Line(Arrays.asList(first, first.next(false)));
        assertThat(line.move(1)).isEqualTo(0);
    }

    @Test
    void move_multi() {
        Point first = Point.first(false);
        Line line = new Line(Arrays.asList(first, first.next(false)));
        assertThat(line.move(0)).isEqualTo(0);
    }
}
