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
        List<Point> points = new ArrayList<>();;
        addFirstPoint(lineStrategy, points);
        addMiddlePoint(countOfPerson, lineStrategy, points);
        addLastPoint(points);
        return points;
    }

    private static void addFirstPoint(LineStrategy lineStrategy, List<Point> points) {
//        points.add(Point.createFirstPoint(lineStrategy));
    }

    private static void addMiddlePoint(int countOfPerson, LineStrategy lineStrategy, List<Point> points) {
//        IntStream.range(1, countOfPerson - 1).forEach(i ->
//                points.add(Point.createMiddlePoint(points.get(i - 1), lineStrategy)));
    }

    private static void addLastPoint(List<Point> points) {
        //points.add(Point.createLastPoint());
    }

    public Point get(int index) {
        return points.get(index);
    }

    public int size() {
        return points.size();
    }

    public int getNextPosition(int position) {
//        int nextPosition = position + points.get(position).getNextPosition();
        if (position > LEAST_POSITION) {
//            nextPosition -= points.get(position - POINT_DISTANCE).getNextPosition();
        }
        return 0;
    }
}
