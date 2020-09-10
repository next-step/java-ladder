package ladder.tdd;

import ladder.domain.rule.DrawRule;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {
    private final List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public static LadderLine init(int sizeOfPerson, DrawRule drawRule) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points, drawRule);
        point = initBody(sizeOfPerson, points, point);
        initLast(points, point);
        return new LadderLine(points);
    }

    public int move(int position) {
        return points.get(position).move();
    }

    private static Point initFirst(List<Point> points, DrawRule drawRule) {
        Point point = Point.first(drawRule.isDrawable());
        points.add(point);
        return point;
    }

    private static Point initBody(int sizeOfPerson, List<Point> points, Point point) {
        for (int i = 1; i < sizeOfPerson - 1; i++) {
            point = point.next();
            points.add(point);
        }
        return point;
    }

    private static void initLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    public boolean hasLine(int column) {
        return this.points.get(column).getDirection().isRight() &&
                this.points.get(column + 1).getDirection().isLeft();
    }

    public List<Point> getPoints() {
        return this.points;
    }

    @Override
    public String toString() {
        return "LadderLine{" +
                "points=" + points +
                '}';
    }
}
