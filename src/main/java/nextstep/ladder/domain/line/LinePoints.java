package nextstep.ladder.domain.line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import nextstep.ladder.domain.point.Point;
import nextstep.ladder.domain.point.PointGenerator;

public class LinePoints {

    private List<Point> points;

    private LinePoints(List<Point> points) {
        validate(points);
        this.points = points;
    }

    public static LinePoints of(int countOfPerson, PointGenerator pointGenerator) {
        if (countOfPerson < 2) {
            throw new IllegalArgumentException("count of person must be more than one");
        }

        List<Point> points = new ArrayList<>(Arrays.asList(Point.first(pointGenerator)));

        for (int i = 1; i < countOfPerson - 1; i++) {
            Point pre = points.get(i - 1);
            points.add(pre.next(pointGenerator));
        }

        points.add(Point.last());
        return of(points);
    }

    public static LinePoints of(List<Point> points) {
        return new LinePoints(points);
    }

    public List<Point> getPoints() {
        return new ArrayList<>(points);
    }

    public int move(int position) {
        if (position == 0) {
            return points.get(0).hasRight() ? position + 1 : position;
        }

        Point pre = this.points.get(position - 1);
        if(pre.hasRight()){
            return position -1;
        }

        if(this.points.get(position).hasRight()){
            return position + 1;
        }

        return position;
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
