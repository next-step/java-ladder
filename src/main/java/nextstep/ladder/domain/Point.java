package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Point {
    public static final Random RANDOM = new Random();
    public static final int RANDOM_END = 10;

    public static final int RANDOM_BOUNDARY = 5;

    private static final Map<String, Point> POINT_FOR_CASH = new HashMap<>();

    static {
        POINT_FOR_CASH.put("left", new Point("left"));
        POINT_FOR_CASH.put("right", new Point("right"));
        POINT_FOR_CASH.put("none", new Point("none"));
    }

    private final String point;

    private Point(String point) {
        this.point = point;
    }

    public static Point of(String point) {
        return POINT_FOR_CASH.get(point);
    }


    public static Point ofRandomFirstPoint() {
        int randomNumber = RANDOM.nextInt(RANDOM_END);
        if (randomNumber > RANDOM_BOUNDARY) {
            return Point.of("right");
        } else if (randomNumber <= RANDOM_BOUNDARY) {
            return Point.of("none");
        }
        return null;
    }

    public static Point ofRandomLastPoint(Point previousPoint) {
        if (previousPoint == Point.of("right")) {
            return Point.of("left");
        }
        if (previousPoint != Point.of("right")) {
            return Point.of("none");
        }
        return null;
    }
}
