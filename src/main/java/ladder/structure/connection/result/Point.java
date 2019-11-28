package ladder.structure.connection.result;

import java.util.HashMap;
import java.util.Map;

public class Point {
    private static final int MOVE_RIGHT = 1;
    private static final int MOVE_STRAIGHT = 0;
    private static final int MOVE_LEFT = -1;
    private static final Map<Integer, Point> preset = new HashMap<>();
    private int point;

    private Point(int num) {
        this.point = num;
    }

    public static Point of(int num) {
        Point point = preset.get(num);
        if (point == null) {
            point = new Point(num);
            preset.put(num, point);
        }
        return point;
    }

    public Point move(boolean possibleToGoLeft, boolean possibleToGoRight) {
        if (possibleToGoLeft) {
            return Point.of(this.point + MOVE_LEFT);
        }
        if (possibleToGoRight) {
            return Point.of(this.point + MOVE_RIGHT);
        }
        return Point.of(this.point + MOVE_STRAIGHT);
    }

    public int value() {
        return point;
    }
}
