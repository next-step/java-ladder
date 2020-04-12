package nextstep.ladder;

import nextstep.ladder.domain.Line2;
import nextstep.ladder.domain.Point2;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Line2Test {
    @Test
    public void init() {
        int sizeOfPerson = 5;
        System.out.println(Line2.init(sizeOfPerson));
    }

    @Test
    public void move1() {
        Line2 line = Line2.init(2);
        System.out.println("ladder result : " + line.move(0));
    }

    /**
     * |     |-----|
     */
    @Test
    void move2() {
        List<Point2> points = new ArrayList<>();
        Point2 point = Point2.first(false);
        points.add(point);
        point = point.next(true);
        points.add(point);
        point = point.last();
        points.add(point);

        Line2 line = new Line2(points);

        assertThat(line.move(0)).isEqualTo(0);
        assertThat(line.move(1)).isEqualTo(2);
        assertThat(line.move(2)).isEqualTo(1);
    }

    /**
     * |-----|     |
     */
    @Test
    void move3() {
        List<Point2> points = new ArrayList<>();
        Point2 point = Point2.first(true);
        points.add(point);
        point = point.next();
        points.add(point);
        point = point.last();
        points.add(point);

        Line2 line = new Line2(points);

        assertThat(line.move(0)).isEqualTo(1);
        assertThat(line.move(1)).isEqualTo(0);
        assertThat(line.move(2)).isEqualTo(2);
    }
}
