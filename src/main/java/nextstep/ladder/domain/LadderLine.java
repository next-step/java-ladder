package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static nextstep.ladder.util.RandomUtils.randomBoolean;

public class LadderLine {
    private final List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public static LadderLine init(int sizeOfPerson) {
        List<Point> points = new ArrayList<>();
        initFirst(points);
        initBody(sizeOfPerson, points);
        initLast(points);
        return new LadderLine(points);
    }

    private static Point initFirst(List<Point> points) {
        Point point = Point.first(randomBoolean());
        points.add(point);
        return point;
    }

    private static Point initBody(int sizeOfPerson, List<Point> points) {
        Point point = getLastPoint(points);
        for (int i = 1; i < sizeOfPerson - 1; i++) {
            point = point.next();
            points.add(point);
        }
        return point;
    }

    private static void initLast(List<Point> points) {
        Point point = getLastPoint(points);
        point = point.last();
        points.add(point);
    }

    private static Point getLastPoint(List<Point> points) {
        return points.get(points.size() - 1);
    }

    @Override
    public String toString() {
        return "LadderLine{" +
                "points=" + points +
                '}';
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
