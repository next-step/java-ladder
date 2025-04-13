package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = List.copyOf(points);
    }

    public static Line generate(int numLines, LineDrawStrategy strategy) {
        List<Point> result = new ArrayList<>();
        boolean prevHasRight = false;

        for (int i = 0; i < numLines; i++) {
            boolean draw = strategy.draw(prevHasRight);
            result.add(new Point(draw));
            prevHasRight = draw;
        }

        return new Line(result);
    }

    public List<Point> getPoints() {
        return points;
    }
}
