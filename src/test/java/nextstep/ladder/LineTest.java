package nextstep.ladder;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    public void init() {
        int sizeOfPerson = 5;
        System.out.println(Line.init(sizeOfPerson));
    }

    @Test
    public void move1() {
        Line line = Line.init(2);
        System.out.println("ladder result : " + line.move(0));
    }

    /**
     * |     |-----|
     */
    @Test
    void move2() {
        List<Point> points = new ArrayList<>();
        Point point = Point.first(false);
        points.add(point);
        point = point.next(true);
        points.add(point);
        point = point.last();
        points.add(point);

        Line line = new Line(points);

        assertThat(line.move(0)).isEqualTo(0);
        assertThat(line.move(1)).isEqualTo(2);
        assertThat(line.move(2)).isEqualTo(1);
    }

    /**
     * |-----|     |
     */
    @Test
    void move3() {
        List<Point> points = new ArrayList<>();
        Point point = Point.first(true);
        points.add(point);
        point = point.next();
        points.add(point);
        point = point.last();
        points.add(point);

        Line line = new Line(points);

        assertThat(line.move(0)).isEqualTo(1);
        assertThat(line.move(1)).isEqualTo(0);
        assertThat(line.move(2)).isEqualTo(2);
    }
}
