package nextstep.ladder.domain.ladder;

import java.util.HashMap;
import java.util.Map;

public class Point {
    private final boolean connect;
    private final static Map<Boolean, Point> cachePoint;

    static {
        cachePoint = new HashMap<>();
        cachePoint.put(true, new Point(true));
        cachePoint.put(false, new Point(false));
    }

    private Point(boolean connect) {
        this.connect = connect;
    }

    public static Point of(boolean connect) {
        return cachePoint.get(connect);
    }

    public boolean isConnect() {
        return connect;
    }
}
