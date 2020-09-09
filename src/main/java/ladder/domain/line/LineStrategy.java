package ladder.domain.line;

import ladder.domain.Point;

public interface LineStrategy {
    public static final int LAST_VALUE = 1;

    public Point makePoint(Point prevPoint, int lastValue);

}
