package ladder.domain.ladder;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    public void first(){
        Point point = Point.first(true);

        assertThat(point.isLeft()).isFalse();
    }

    @Test
    public void next() {
        Point point = Point.first(false).next(false);

        assertThat(point.isRight()).isFalse();
    }

    @Test
    public void last() {
        Point point = Point.first(false).last(true);

        assertThat(point.isRight()).isFalse();
    }

    @Test
    public void moveRight() {
        Point point = Point.first(false).next(true);

        int expected = point.move();

        assertThat(point.getCurrentIndex() + 1).isEqualTo(expected);
    }

    @Test
    public void Notmove() {
        Point point = Point.first(false).next(false);

        int expected = point.move();

        assertThat(point.getCurrentIndex()).isEqualTo(expected);
    }

    @Test
    public void leftMove() {
        List<Point> points = new ArrayList<>();

        Point point = Point.first(false);
        points.add(point);
        Point point2 = point.next(true);
        points.add(point2);

        points.add(point2.next(false));

        int expected = points.get(points.size()-1).move();

        assertThat(points.get(points.size()-1).getCurrentIndex() -1).isEqualTo(expected);
    }
}