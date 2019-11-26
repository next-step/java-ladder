package ladder.game;

import java.util.HashMap;
import java.util.Map;

public class Point {
    private static final Map<Integer, Point> preset = new HashMap<>();
    private Integer point;

    private Point(Integer num) {
        this.point = num;
    }

    public static Point of(Integer num) {
        Point point = preset.get(num);
        if (point == null) {
            point = new Point(num);
            preset.put(num, point);
        }
        return point;
    }

    public Integer getPoint() {
        return point;
    }
}
