package domain;

import strategy.PointsMakeStrategy;

import java.util.Iterator;
import java.util.List;

public class Line implements Iterable<Boolean>  {
    public static final int FIRST_POINT_INDEX = 0;
    private final List<Boolean> points;

    public static Line from(int playerCount, PointsMakeStrategy pointsMakeStrategy) {
        List<Boolean> points = pointsMakeStrategy.makePoints(playerCount);
        return new Line(points);
    }

    private Line(List<Boolean> points) {
        this.points = points;
    }

    @Override
    public Iterator<Boolean> iterator() {
        return points.iterator();
    }

    public PointDirection checkPointDirection(int playerPoint) {
        if (isFarLeft(playerPoint)) {
            return rightPointOrNone(playerPoint);
        }
        if (isFarRight(playerPoint)) {
            return leftPointOrNone(playerPoint);
        }
        if (isExistPoint(playerPoint)) {
            return PointDirection.RIGHT;
        }
        if (isExistPoint(playerPoint - 1)) {
            return PointDirection.LEFT;
        }

        return PointDirection.NONE;
    }

    private Boolean isExistPoint(int playerPoint) {
        return points.get(playerPoint);
    }

    private boolean isFarRight(int playerPoint) {
        return playerPoint == (points.size());
    }

    private boolean isFarLeft(int playerPoint) {
        return playerPoint == FIRST_POINT_INDEX;
    }

    private PointDirection leftPointOrNone(int playerPoint) {
        if (isExistPoint(playerPoint - 1)) {
            return PointDirection.LEFT;
        }
        return PointDirection.NONE;
    }

    private PointDirection rightPointOrNone(int playerPoint) {
        if (isExistPoint(playerPoint)) {
            return PointDirection.RIGHT;
        }
        return PointDirection.NONE;
    }
}
