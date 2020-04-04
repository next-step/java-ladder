package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class Point {
    private boolean rightDirection;
    private static Map<Boolean, Point> cache;

    static {
        cache = new HashMap<>();
        cache.put(true, new Point(true));
        cache.put(false, new Point(false));
    }

    public static Point of(boolean rightDirection) {
        return cache.get(rightDirection);
    }

    private Point(boolean rightDirection) {
        this.rightDirection = rightDirection;
    }

    public boolean hasRightDirection() {
        return this.rightDirection;
    }
}
