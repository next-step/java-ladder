package ladder_refactor.domain;

import java.util.ArrayList;
import java.util.List;

import static ladder_refactor.domain.LadderPointGenerator.generatePoint;

public class LadderLine {
    private final List<Point> points;

    private LadderLine(List<Point> points) {
        this.points = points;
    }

    public int move(int position) {
        return this.points.get(position).move();
    }

    public static LadderLine init(int sizeOfPerson) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points);
        point = initBody(sizeOfPerson, points, point);
        initLast(points, point);
        return new LadderLine(points);
    }

    public static LadderLine init(List<Point> points) {
        return new LadderLine(points);
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

    private static Point initFirst(List<Point> points) {
        Point point = Point.first(generatePoint());
        points.add(point);
        return point;
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LadderLine{");
        sb.append("points=").append(points);
        sb.append('}');
        return sb.toString();
    }
}
