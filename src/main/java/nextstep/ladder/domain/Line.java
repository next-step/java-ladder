package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private static final Random RANDOM = new Random();

    private List<Point> points;

    private Line(List<Point> points) {
        validate(points);
        this.points = points;
    }

    private static void validate(List<Point> points) {
        if (points == null || points.isEmpty()) {
            throw new IllegalArgumentException("점이 없습니다.");
        }
    }

    public static Line createLine(int countOfPerson) {
        return new Line(generateRandomMoveablePoints(countOfPerson));
    }

    private static List<Point> generateRandomMoveablePoints(int count) {
        List<Point> points = new ArrayList<>();

        points.add(Point.leftmostPoint(RANDOM.nextBoolean()));
        points.addAll(generateMiddlePoints(count, points));
        points.add(Point.rightmostPoint(getLastPoint(points).canMoveLeft()));

        return points;
    }

    private static List<Point> generateMiddlePoints(int count, List<Point> points) {
        return IntStream.range(0, count - 2)
                .mapToObj(i -> generateMiddlePoint(points))
                .collect(Collectors.toList());
    }

    private static Point generateMiddlePoint(List<Point> points) {
        boolean leftMoveable = getLastPoint(points).canMoveRight();
        boolean rightMoveable = !leftMoveable && RANDOM.nextBoolean();
        return new Point(leftMoveable, rightMoveable);
    }

    private static Point getLastPoint(List<Point> points) {
        return points.get(points.size() - 1);
    }

    public int size() {
        return points.size();
    }

    public Point getPoint(int index) {
        return points.get(index);
    }
}
