package study.core;

import study.util.RandomUtil;

import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public void createPoints(int playerCount) {
        Point firstPoint = new Point(0, Edge.first(RandomUtil.nextBoolean()));
        points.add(firstPoint);
        Point nextPoint = firstPoint;
        for (int i = 1; i < playerCount - 1; i++) {
            nextPoint = new Point(i, nextPoint.getEdge().next(RandomUtil.nextBoolean()));
            points.add(nextPoint);
        }
        points.add(new Point(playerCount - 1, nextPoint.getEdge().last()));
    }
}
