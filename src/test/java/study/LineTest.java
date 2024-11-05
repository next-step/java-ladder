package study;

import org.junit.jupiter.api.Test;
import study.core.Edge;
import study.core.Line;
import study.core.Point;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    void create() {
        Line line = new Line(new ArrayList<>());
        line.createPoints(5);
        assertThat(line.getPoints().size()).isEqualTo(5);
    }

    @Test
    void 연속_연결시_끊기게_생성() {
        Edge first = Edge.first(true);
        Edge second = first.next(true);
        Edge last = second.last();

        Line line = new Line(List.of(new Point(0, first), new Point(1, second), new Point(2, last)));
        assertThat(line.getPoints().get(1).isCurrent()).isFalse();
    }

    @Test
    void move() {
        Edge first = Edge.first(true);
        Edge second = first.next(false);
        Edge third = second.next(true);
        Edge last = third.last();
        List<Point> points = List.of(new Point(0, first), new Point(1, second), new Point(2, third), new Point(3, last));
        Line line = new Line(points);
        assertThat(line.move(0)).isEqualTo(1);
        assertThat(line.move(1)).isEqualTo(0);
        assertThat(line.move(2)).isEqualTo(3);
        assertThat(line.move(3)).isEqualTo(2);
    }
}
