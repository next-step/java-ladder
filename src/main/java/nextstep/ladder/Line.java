package nextstep.ladder;

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
        return new Line(generateRandomPoints(countOfPerson));
    }

    private static List<Point> generateRandomPoints(int count) {
        List<Point> points = new ArrayList<>();

        boolean moveable = RANDOM.nextBoolean();
        points.add(Point.leftmostPoint(moveable));

        boolean leftMoveable = moveable;
        for (int i = 1; i < count - 2; i++) {
            boolean rightMoveable = RANDOM.nextBoolean();
            if (leftMoveable) {
                rightMoveable = false;
            }
            points.add(new Point(moveable, rightMoveable));
            leftMoveable = rightMoveable;
        }

        points.add(Point.rightmostPoint(leftMoveable));

        return points;
    }
}
