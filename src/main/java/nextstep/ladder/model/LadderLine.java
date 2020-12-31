package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.List;

import static nextstep.ladder.model.LadderPointGenerator.generatePoint;

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
        Point point = initFirst(sizeOfPerson, points);
        point = initBody(sizeOfPerson, points, point);
        initLast(sizeOfPerson, points, point);
        return new LadderLine(points);
    }

    private static Point initBody(int sizeOfPerson, List<Point> points, Point point) {
        for (int i = 1; i < sizeOfPerson - 1; i++) {
            point = point.next();
            points.add(point);
        }
        return point;
    }

    private static void initLast(int sizeOfPerson, List<Point> points, Point point) {
        if (sizeOfPerson != 1) {
            point = point.last();
            points.add(point);
        }
    }

    private static Point initFirst(int sizeOfPerson, List<Point> points) {
        Point point;

        if (sizeOfPerson == 1) {
            point = Point.first(false);
            points.add(point);
            return point;
        }

        point = Point.first(generatePoint());
        points.add(point);
        return point;
    }

    @Override
    public String toString() {
        return "LadderLine{" +
                "points=" + points +
                "}";
    }
}
