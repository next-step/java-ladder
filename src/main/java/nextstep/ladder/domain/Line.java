package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line of(int countOfPerson, PointStrategy strategy) {
        List<Point> points = new ArrayList<>();
        boolean previous = false;

        for (int i = 0; i < countOfPerson - 1; i++) {
            boolean current = decidePoint(previous, strategy);
            points.add(new Point(current));
            previous = current;
        }

        return new Line(points);
    }

    public boolean isConnected(int index) {
        return points.get(index).isConnected();
    }

    public int size() {
        return points.size();
    }

    private static boolean decidePoint(boolean previous, PointStrategy strategy) {
        if (previous) {
            return false;
        }
        return strategy.generate();
    }
}
