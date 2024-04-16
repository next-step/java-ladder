package domain;

import strategy.PointsMakeStrategy;

import java.util.Iterator;
import java.util.List;

public class Line implements Iterable<Point>  {
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
        Point point = points.get(player.getPosition());
        return point.move();
    }
}
