package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {
    private static final int MIN_SIZE_OF_PERSON = 2;
    private static final String CREATE_LADDER_LINE_ERROR = MIN_SIZE_OF_PERSON + "명 이상의 플레이어가 필요합니다.";
    private final List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public static LadderLine init(int sizeOfPerson) {
        if (sizeOfPerson < MIN_SIZE_OF_PERSON) {
            throw new IllegalArgumentException(CREATE_LADDER_LINE_ERROR);
        }
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

    private static Boolean generatePoint() {
        return new RandomPointCreator().createPoint();
    }

    public int size() {
        return this.points.size();
    }

    @Override
    public String toString() {
        return "LadderLine{" +
                "points=" + points +
                '}';
    }
}
