package ladder.domain.ladder;

import ladder.domain.strategy.LineStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

    public static final int LEAST_POSITION = 0;
    public static final int POINT_DISTANCE = 1;

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line of(int countOfPerson, LineStrategy lineStrategy) {
        return new Line(getPoints(countOfPerson, lineStrategy));
    }

    private static List<Point> getPoints(int countOfPerson, LineStrategy lineStrategy) {
        List<Point> points = new ArrayList<>();
        points.add(Point.createFirstPoint(lineStrategy));
        IntStream.range(1, countOfPerson - 1).forEach(i ->
                points.add(Point.createMiddlePoint(points.get(i - 1), lineStrategy)));
        points.add(Point.createLastPoint());
        return points;
    }

    public Point get(int index) {
        return points.get(index);
    }

    public int size() {
        return points.size();
    }

    public int getNextPosition(int position) {
        int nextPosition = position + points.get(position).getNextPosition();
        if (position > LEAST_POSITION) {
            nextPosition -= points.get(position - POINT_DISTANCE).getNextPosition();
        }
        return nextPosition;
    }
}
