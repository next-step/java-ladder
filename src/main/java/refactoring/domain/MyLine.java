package refactoring.domain;

import java.util.List;

public class MyLine implements Line {

    private final List<Point> points;

    public MyLine(final List<Point> points) {
        this.points = points;
    }

    @Override
    public int toResult(final int position) {
       return points.get(position).move();
    }

    @Override
    public List<Point> getPoint() {
        return points;
    }
}
