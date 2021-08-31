package nextstep.ladder2.domain;

import nextstep.ladder.application.RandomCreatePoint;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {
    private List<Point> points = new ArrayList<>();

    public LadderLine(int personCount) {
        init(personCount);
    }

    private void init(int personCount) {
        Point firstPoint = initFirst();
        Point beforeLastPoint = pointdrawLine(personCount, firstPoint);
        initLast(beforeLastPoint);
    }

    private void initLast(Point beforeLastPoint) {
        points.add(beforeLastPoint.last());
    }

    private Point pointdrawLine(int personCount, Point point) {
        for (int i = 1; i < personCount - 1; i++) {
            point = point.next();
            points.add(point);
        }
        return point;
    }

    private Point initFirst() {
        Point firstPoint = Point.first(RandomCreatePoint.of().isDraw());
        points.add(firstPoint);
        return firstPoint;
    }

    public int getPointSize() {
        return this.points.size();
    }

    public int move(int posiotionIndex) {
        return points.get(posiotionIndex).move();
    }

    public Point getPoint(int pointIndex) {
        return points.get(pointIndex);
    }
}
