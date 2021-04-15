package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

import static nextstep.ladder.LadderPointGenerator.generatePoint;

public class LadderLine {
    private final static int MIN_LENGTH = 2;
    private final List<Point> points;

    public LadderLine(List<Point> points) {
        validation(points);
        this.points = points;
    }

    private void validation(List<Point> points) {
        if (points.size() < MIN_LENGTH) {
            throw new IllegalArgumentException("최소 좌표 생성 개수는 2개 이상이어야 합니다.");
        }
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public static LadderLine init(int sizeOfPerson) {
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

    @Override
    public String toString() {
        return "LadderLine{" +
                "points=" + points +
                '}';
    }
}
