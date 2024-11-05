package study;

import org.junit.jupiter.api.Test;
import study.core.Edge;
import study.core.Point;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @Test
    void moveToLeft() {
        Point point = new Point(1, Edge.first(true).next(false));
        assertThat(point.move()).isEqualTo(0);
    }

    @Test
    void moveToRight() {
        Point point = new Point(1, Edge.first(false).next(true));
        assertThat(point.move()).isEqualTo(2);
    }

    @Test
    void pass() {
        Point point = new Point(1, Edge.first(false));
        assertThat(point.move()).isEqualTo(1);
    }
}
