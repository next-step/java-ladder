package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private static final Random RANDOM = new Random();

    private List<Point> points;

    private Line(List<Point> points) {
        if (points == null || points.isEmpty()) {
            throw new IllegalArgumentException("점이 없습니다.");
        }
        this.points = points;
    }

    public static Line createLine(int countOfPerson) {
        return new Line(generateRandomMoveablePoints(countOfPerson));
    }

    private static List<Point> generateRandomMoveablePoints(int count) {
        List<Point> points = new ArrayList<>();

        boolean moveable = RANDOM.nextBoolean();
        points.add(Point.leftmostPoint(moveable));
        points.addAll(generateMiddlePoints(count, points.get(points.size() - 1).canMoveRight()));
        points.add(Point.rightmostPoint(points.get(points.size() - 1).canMoveLeft()));

        return points;
    }

    private static List<Point> generateMiddlePoints(int count, boolean startPointMoveable) {
        List<Point> middlePoints = new ArrayList<>();

        boolean leftMoveable = startPointMoveable;
        for (int i = 0; i < count - 2; i++) {
            boolean rightMoveable = !leftMoveable && RANDOM.nextBoolean();
            middlePoints.add(new Point(leftMoveable, rightMoveable));
            leftMoveable = rightMoveable;
        }
        return middlePoints;
    }

    public int size() {
        return points.size();
    }

    public Point getPoint(int index) {
        return points.get(index);
    }
}
