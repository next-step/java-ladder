package domain;

import strategy.PointsMakeStrategy;

import java.util.Iterator;
import java.util.List;

public class Line implements Iterable<Boolean>  {
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
}
