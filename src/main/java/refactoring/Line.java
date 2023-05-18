package refactoring;

import java.util.List;
import refactoring.domain.Point;

public class Line {

    private final List<Point> points;

    public Line(final List<Point> points) {
        this.points = points;
    }

    public int toResult(final int position) {
       return points.get(position).move();
    }
}
