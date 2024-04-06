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
        return new Line(createPoints(countOfPerson));
    }

    private static List<Point> createPoints(int count) {
        List<Point> points = new ArrayList<>();

        boolean moveable = RANDOM.nextBoolean();
        points.add(createFirstPoint(moveable));

        boolean leftMoveable = moveable;
        for (int i = 1; i < count - 2; i++) {
            boolean rightMoveable = RANDOM.nextBoolean();
            if (leftMoveable) {
                rightMoveable = false;
            }
            points.add(new Point(moveable, rightMoveable));
            leftMoveable = rightMoveable;
        }

        points.add(createLastPoint(leftMoveable));

        return points;
    }

    private static Point createLastPoint(boolean leftMoveable) {
        return new Point(leftMoveable, false);
    }

    private static Point createFirstPoint(boolean rightMoveable) {
        return new Point(false, rightMoveable);
    }
}
