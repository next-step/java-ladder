package nextstep.ladder.domain;

import java.util.List;

public class Points {

    List<Point> points;

    public Points(List<Point> points) {
        this.points = points;
    }

    public List<Point> points() {
        return this.points;
    }

    public void add(Point point) {
        this.points.add(point);
    }

    public boolean isEmpty() {
        return this.points.isEmpty();
    }

    public boolean isLastTrue() {
        return this.points.get(this.points.size() - 1).isTrue();
    }

    public boolean isLastFalse() {
        return this.points.get(this.points.size() - 1).isFalse();
    }
}
