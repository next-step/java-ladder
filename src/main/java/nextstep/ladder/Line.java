package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private static final int MIN_COUNT_OF_PERSON = 2;
    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line of(int countOfPerson) {
        if (countOfPerson < MIN_COUNT_OF_PERSON) {
            throw new IllegalArgumentException("라인은 최소 " + MIN_COUNT_OF_PERSON + "명 이상의 참가자가 있어야 합니다.");
        }

        List<Point> points = new ArrayList<>();
        Point point = new Point();
        points.add(point);

        for (int idx = 1; idx < countOfPerson - 1; idx++) {
            Point nextPoint = point.nextPoint();
            points.add(nextPoint);
            point = nextPoint;
        }

        return new Line(points);
    }

    public List<Point> points() {
        return new ArrayList<>(points);
    }
}