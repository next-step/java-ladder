package ladder.domain;

import ladder.domain.exception.InvalidCountOfPersonException;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final int FIRST_INDEX = 0;
    private static final int BODY_LAST_INDEX_DIFFERENCE = 1;
    private static final int COUNT_OF_PERSON_MIN = 1;
    private static final int COUNT_OF_PERSON_ONLY = 1;

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line init(int countOfPerson) {
        if (countOfPerson < COUNT_OF_PERSON_MIN) {
            throw new InvalidCountOfPersonException();
        }

        return new Line(initPoints(countOfPerson));
    }

    private static List<Point> initPoints(int countOfPerson)  {
        List<Point> points = new ArrayList<>();

        initFirst(points, countOfPerson);
        initBody(points, countOfPerson);
        initLast(points, countOfPerson);

        return points;
    }

    private static void initFirst(List<Point> points, int countOfPerson) {
        if (countOfPerson == COUNT_OF_PERSON_ONLY) {
            points.add(Point.first(false));
            return;
        }

        points.add(Point.first(DirectionGenerator.shouldMove()));
    }

    private static void initBody(List<Point> points, int countOfPerson) {
        Point point = points.get(FIRST_INDEX);

        int bodyCount = countOfPerson - BODY_LAST_INDEX_DIFFERENCE;
        for (int i = FIRST_INDEX + 1; i < bodyCount; i++) {
            point = point.next();
            points.add(point);
        }
    }

    private static void initLast(List<Point> points, int countOfPerson) {
        if (points.size() >= countOfPerson) {
            return;
        }

        Point point = points.get(points.size() - BODY_LAST_INDEX_DIFFERENCE);
        points.add(point.last());
    }

    public int move(int index) {
        return points.get(index).move();
    }

    public List<Point> getPoints() {
        return points;
    }

    public boolean isCountOfPerson(int countOfPerson) {
        return this.points.size() == countOfPerson;
    }
}
