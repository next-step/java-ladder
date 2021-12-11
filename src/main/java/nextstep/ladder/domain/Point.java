package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Point {
    private static final Random RANDOM = new Random();
    private static final int RANDOM_END = 10;
    private static final int RANDOM_BOUNDARY = 5;
    private static final Map<String, Point> POINT_FOR_CASH = new HashMap<>();

    static {
        POINT_FOR_CASH.put("true", new Point(true));
        POINT_FOR_CASH.put("false", new Point(false));
    }

    private final boolean point;

    private Point(boolean point) {
        this.point = point;
    }

    public static Point of(Boolean point) {
        return POINT_FOR_CASH.get(point.toString());
    }

    public static Point ofRandom() {
        return Point.of(RANDOM.nextInt(RANDOM_END) > RANDOM_BOUNDARY);
    }
}
