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
        return points.get(player.getPosition());
    }

    private Boolean isExistLeftPoint(Player player) {
        int leftPoint = player.getPosition() - 1;
        return points.get(leftPoint);
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
