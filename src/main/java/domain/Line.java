package domain;

import strategy.PointsMakeStrategy;

import java.util.Iterator;
import java.util.List;

public class Line implements Iterable<Point>  {
    public static final int FIRST_POINT_INDEX = 0;
    private final List<Point> points;

    public static Line from(int playerCount, PointsMakeStrategy pointsMakeStrategy) {
        List<Point> points = pointsMakeStrategy.makePoints(playerCount);
        return new Line(points);
    }

    private Line(List<Point> points) {
        this.points = points;
    }

    @Override
    public Iterator<Point> iterator() {
        return points.iterator();
    }

    public PointDirection checkPointDirection(Player player) {
        if (isFarLeft(player)) {
            return rightPointOrNone(player);
        }
        if (isFarRight(player)) {
            return leftPointOrNone(player);
        }
        if (isExistRightPoint(player)) {
            return PointDirection.RIGHT;
        }
        if (isExistLeftPoint(player)) {
            return PointDirection.LEFT;
        }

        return PointDirection.NONE;
    }

    private Boolean isExistRightPoint(Player player) {
        Point rightPoint = points.get(player.getPosition());
        return rightPoint.isExist();
    }

    private Boolean isExistLeftPoint(Player player) {
        Point leftPoint = points.get(player.getPosition() - 1);
        return leftPoint.isExist();
    }

    private boolean isFarRight(Player player) {
        return player.hasPosition(points.size());
    }

    private boolean isFarLeft(Player player) {
        return player.hasPosition(FIRST_POINT_INDEX);
    }

    private PointDirection leftPointOrNone(Player player) {
        if (isExistLeftPoint(player)) {
            return PointDirection.LEFT;
        }
        return PointDirection.NONE;
    }

    private PointDirection rightPointOrNone(Player player) {
        if (isExistRightPoint(player)) {
            return PointDirection.RIGHT;
        }
        return PointDirection.NONE;
    }
}
