package nextstep.ladder.domain;

import nextstep.ladder.util.pointsgenerator.PointsGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static nextstep.ladder.domain.LadderPointGenerator.generatePoint;

public class LadderLine {
    private final List<Point> points;

    private LadderLine(List<Point> points) {
        this.points = points;
    }

    public static LadderLine init(int sizeOfPerson) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points);
        point = initBody(sizeOfPerson, points, point);
        initLast(points, point);
        return new LadderLine(points);
    }

    public static LadderLine init(int sizeOfPerson, PointsGenerator pointsGenerator) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points, pointsGenerator);
        point = initBody(sizeOfPerson, points, point, pointsGenerator);
        initLast(points, point);
        return new LadderLine(points);
    }

    private static Point initFirst(List<Point> points) {
        Point point = Point.first(generatePoint());
        points.add(point);
        return point;
    }

    private static Point initFirst(List<Point> points, PointsGenerator pointsGenerator) {
        Point point = Point.first(pointsGenerator.generatePoint());
        points.add(point);
        return point;
    }

    private static Point initBody(int sizeOfPerson, List<Point> points, Point point) {
        for (int i = 1; i < sizeOfPerson - 1; i++) {
            point = point.next();
            points.add(point);
        }
        return point;
    }

    private static Point initBody(int sizeOfPerson, List<Point> points, Point point, PointsGenerator pointsGenerator) {
        for (int i = 1; i < sizeOfPerson - 1; i++) {
            point = point.next(pointsGenerator.generatePoint());
            points.add(point);
        }
        return point;
    }

    private static void initLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public void pointsForEach(Consumer<Point> consumer) {
        points.forEach(consumer);
    }

    public int size() {
        return points.size();
    }

    @Override
    public String toString() {
        return "LadderLine{" +
                "points=" + points +
                '}';
    }
}
