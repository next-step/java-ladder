package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private static final int MIN_COUNT_OF_PERSON = 2;
    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line from(List<Point> points) {
        return new Line(points);
    }

    public static Line of(int countOfPerson) {
        validateCountOfPerson(countOfPerson);

        List<Point> points = new ArrayList<>();
        Point point = Point.randomInstance();
        points.add(point);

        for (int idx = 1; idx < countOfPerson - 1; idx++) {
            Point nextPoint = point.nextPoint();
            points.add(nextPoint);
            point = nextPoint;
        }

        return new Line(points);
    }

    private static void validateCountOfPerson(int countOfPerson) {
        if (countOfPerson < MIN_COUNT_OF_PERSON) {
            throw new IllegalArgumentException("라인은 최소 " + MIN_COUNT_OF_PERSON + "명 이상의 참가자가 있어야 합니다.");
        }
    }

    public List<Point> points() {
        return new ArrayList<>(points);
    }

    private boolean moveLeft(int curPosition) {
        if (curPosition <= 0) {
            return false;
        }

        return points.get(curPosition - 1).isActive();
    }

    private boolean moveRight(int curPosition) {
        if (curPosition >= points.size()) {
            return false;
        }

        return points.get(curPosition).isActive();
    }

    public int nextPosition(int curPosition) {
        if (moveLeft(curPosition)) {
            return -1;
        }

        if (moveRight(curPosition)) {
            return 1;
        }

        return 0;
    }
}