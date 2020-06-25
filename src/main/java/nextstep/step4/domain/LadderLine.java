package nextstep.step4.domain;

import nextstep.step4.domain.strategy.DrawLineStrategy;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {
    private List<Point> points;
    private DrawLineStrategy drawLineStrategy;

    public List<Point> getPoints() {
        return points;
    }

    public LadderLine(int userCount, DrawLineStrategy drawLineStrategy) {
        this.drawLineStrategy = drawLineStrategy;
        points = new ArrayList<>();
        Point point = initFirstPoint(points);
        point = initBodyPoint(userCount, points, point);
        initLastPoint(points, point);
    }

    private void initLastPoint(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    private Point initBodyPoint(int userCount, List<Point> points, Point point) {
        for (int i = 1; i < userCount - 1; i++) {
            point = point.next(drawLineStrategy.isDrawLine());
            points.add(point);
        }
        return point;
    }

    private Point initFirstPoint(List<Point> points) {
        Point point = Point.first(drawLineStrategy.isDrawLine());
        points.add(point);
        return point;
    }

    public int move(int position) {
        return points.get(position).move();
    }
}
