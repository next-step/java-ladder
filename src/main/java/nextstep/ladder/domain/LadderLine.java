package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {
    private final List<Point> points;
    private static final int LAST_PERSON = 1;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public static LadderLine init(int sizeOfPerson, LineMakeStrategy lineMakeStrategy) {
        List<Point> points = new ArrayList<>();

        Point point = initFirst(points, lineMakeStrategy);
        point = initBody(sizeOfPerson, points, point);
        initLast(points, point);
        return new LadderLine(points);
    }

    private static Point initBody(int sizeOfPerson, List<Point> points, Point point) {
        for (int i = 1; i < sizeOfPerson - LAST_PERSON; i++) {
            point = point.next();
            points.add(point);
        }
        return point;
    }

    private static void initLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    private static Point initFirst(List<Point> points, LineMakeStrategy lineMakeStrategy) {
        Point point = Point.first(lineMakeStrategy.canMake());
        points.add(point);
        return point;
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "LadderLine{" +
                "points=" + points +
                '}';
    }
}
