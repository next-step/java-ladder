package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static ladder.domain.ladder.RandomGenerator.isMovable;

public class Line {

    private static final int PERSON_START_END_COUNT = 2;

    private List<Point> points;

    private Line (List<Point> points) {
        this.points = points;
    }

    public static Line createLine(LineCount lineCount) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points);
        point = initBody(lineCount, points, point);
        initLast(points, point);
        return new Line(points);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    private static Point initBody(LineCount lineCount, List<Point> points, Point point) {
        for (int i = 1; i < lineCount.getLineCount(); i++) {
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
        Point point = Point.first(isMovable());
        points.add(point);
        return point;
    }

    private int getMiddlePerson(int countOfPerson) {
        return countOfPerson - PERSON_START_END_COUNT;
    }
}
