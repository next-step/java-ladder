package ladder.domain.ladder;

import ladder.strategy.LineStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {

    private final List<Point> points = new ArrayList<>();

    public Line(int players, LineStrategy strategy) {
        Point first = Point.first(strategy.isEnableLine());
        points.add(first);
        Point middle = first;
        for (int i = 1; i < players - 1; i++) {
            middle = Point.middle(middle, strategy.isEnableLine());
            points.add(middle);
        }
        Point last = Point.last(middle);
        points.add(last);
    }

    public int move(int index) {
        index = points.get(index).move();
        return index;
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return points + " ";
    }

}
