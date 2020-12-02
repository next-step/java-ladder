package step2.hint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LadderLine {
    private final List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public static LadderLine init(int sizeOfPerson, LadderPointGenerator ladderPointGenerator) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points, ladderPointGenerator);
        point = initBody(sizeOfPerson, points, point, ladderPointGenerator);
        initLast(points, point);
        return new LadderLine(points);
    }

    private static Point initFirst(List<Point> points, LadderPointGenerator ladderPointGenerator) {
        Point point = Point.first(ladderPointGenerator.generatePoint());
        points.add(point);
        return point;
    }

    private static Point initBody(int sizeOfPerson, List<Point> points, Point point, LadderPointGenerator ladderPointGenerator) {
        for (int i = 1; i < sizeOfPerson - 1; i++) {
            point = point.next(ladderPointGenerator);
            points.add(point);
        }
        return point;
    }

    private static void initLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
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
