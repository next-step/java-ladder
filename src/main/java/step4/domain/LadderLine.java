package step4.domain;

import static step4.util.LadderPointGenerator.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import step4.exception.MinimumPlayerCountException;

public class LadderLine {
    private static final int MIN_PERSON = 2;

    private final List<Point> points;

    public LadderLine(List<Point> points) {
        validate(points.size());
        this.points = points;
    }

    private static void validate(int sizeOfPerson) {
        if (sizeOfPerson < MIN_PERSON) {
            throw new MinimumPlayerCountException("참여자의 수는 최소 " + MIN_PERSON + "명 이상이여야 합니다.");
        }
    }

    public static LadderLine init(int sizeOfPerson) {
        validate(sizeOfPerson);
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points);
        point = initBody(sizeOfPerson, points, point);
        initLast(points, point);
        return new LadderLine(points);
    }

    private static Point initBody(int sizeOfPerson, List<Point> points, Point point) {
        for (int i = 1; i < sizeOfPerson - 1; i++) {
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
        Point point = Point.first(generatePoint());
        points.add(point);
        return point;
    }

    public Position move(Position position) {
        return points.get(position.toNumber()).move();
    }

    public List<Point> points() {
        return Collections.unmodifiableList(this.points);
    }

    @Override
    public String toString() {
        return "LadderLine{" +
            "points=" + points +
            '}';
    }
}
