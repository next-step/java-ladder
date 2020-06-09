package nextstep.ladder.domain.line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import nextstep.ladder.domain.point.Point;
import nextstep.ladder.domain.point.PointGenerator;

public class LinePoints {

    private List<Point> points;

    LinePoints(List<Point> points) {
        validate(points);
        this.points = points;
    }

    public static LinePoints of(int countOfPerson, PointGenerator pointGenerator) {
        if (countOfPerson < 2) {
            throw new IllegalArgumentException("count of person must be more than one");
        }

        List<Point> points = new ArrayList<>(Arrays.asList(Point.first(pointGenerator)));

        points.addAll(middle(points.get(0), countOfPerson - 2, pointGenerator));

        Point last = points.get(points.size() - 1).last();
        points.add(last);
        return new LinePoints(points);
    }

    private static List<Point> middle(Point pre, int size, PointGenerator pointGenerator) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Point next = pre.next(pointGenerator);
            points.add(next);
            pre = next;
        }
        return points;
    }

    public List<Point> getPoints() {
        return new ArrayList<>(points);
    }

    public int move(int position) {
        Point point = this.points.get(position);
        return point.move();
    }

    private void validate(List<Point> points) {
        if (points.isEmpty()) {
            throw new IllegalArgumentException("invalid size of points");
        }

        for (int i = 1; i < points.size(); i++) {
            validatePoint(points.get(i), points.get(i - 1));
        }
    }

    private void validatePoint(Point current, Point pre) {
        if (!current.isValid(pre)) {
            throw new IllegalArgumentException("invalid point");
        }
    }


}
