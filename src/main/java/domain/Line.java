package domain;

import strategy.PointsMakeStrategy;

import java.util.List;

public class Line {
    private final List<Boolean> points;

    public static Line from(int playerCount, PointsMakeStrategy pointsMakeStrategy) {
        List<Boolean> points = pointsMakeStrategy.makePoints(playerCount);
        return new Line(points);
    }

    private Line(List<Boolean> points) {
        this.points = points;
    }
}
