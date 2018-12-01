package domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static domain.ladder.LadderPointGenerator.generatePoint;

public class LadderLine {

    private final List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public static LadderLine init(int sizeOfPerson, int random) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points, random);
        point = initBody(sizeOfPerson, points, point, random);
        initLast(points, point);
        return new LadderLine(points);
    }

    private static void initLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    private static Point initBody(int sizeOfPerson, List<Point> points, Point point, int random) {
        for (int i = 1; i < sizeOfPerson - 1; i++) {
            point = point.next(random);
            points.add(point);
        }
        return point;
    }

    private static Point initFirst(List<Point> points, int random) {
        Point point = Point.first(generatePoint(random));
        points.add(point);
        return point;
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    @Override
    public String toString() {
        return "LadderLine{" +
                "points=" + points +
                '}';
    }
}
