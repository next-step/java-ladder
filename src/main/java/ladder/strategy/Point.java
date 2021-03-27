package ladder.strategy;

import ladder.util.RandomUtil;

public class Point implements PointStrategy{
    private static final int POINT_CONDITION = 1;

    private static final Point point = new Point();

    private Point() { }

    @Override
    public boolean isPoint() {
        return (RandomUtil.value() == POINT_CONDITION);
    }

    public static Point instance() {
        return point;
    }
}
