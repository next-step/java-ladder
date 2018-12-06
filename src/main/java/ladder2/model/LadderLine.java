package ladder2.model;

import ladder2.util.LadderPointGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderLine {
    private final List<Point> points;
    private int countOfPoint;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    private LadderLine(int countOfPoint) {
        this.countOfPoint = countOfPoint;
        this.points = new ArrayList<>();
    }

    public static LadderLine from(int countOfPoint) {
        return new LadderLine(countOfPoint);
    }

    public LadderLine generate(LadderPointGenerator ladderPointGenerator) {
        initLast(initBody(initFirst(ladderPointGenerator), ladderPointGenerator));
        return this;
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public int pointSize() {
        return points.size();
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    private Point initFirst(LadderPointGenerator ladderPointGenerator) {
        Point point = Point.first(ladderPointGenerator.generatePoint());
        points.add(point);
        return point;
    }

    private Point initBody(Point firstPoint, LadderPointGenerator ladderPointGenerator) {
        Point point = firstPoint;
        for (int i = 1; i < countOfPoint - 1; i++) {
            point = point.next(ladderPointGenerator);
            points.add(point);
        }
        return point;
    }

    private void initLast(Point bodyLastPoint) {
        points.add(bodyLastPoint.last());
    }
}
