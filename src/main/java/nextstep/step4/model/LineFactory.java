package nextstep.step4.model;

import java.util.ArrayList;
import java.util.List;

public class LineFactory {
    public static final int MIN_COUNT = 2;

    private LineFactory() {
    }

    public static Line from(int countOfPerson) {
        if (countOfPerson < MIN_COUNT) {
            throw new IllegalArgumentException("최소 인원은 " + MIN_COUNT + "명 입니다");
        }

        List<Point> points = new ArrayList<>();
        Point point = Point.first();
        points.add(point);

        for (int i = 1; i < countOfPerson - 1; i++) {
            point = point.next();
            points.add(point);
        }

        points.add(point.last());

        return new Line(points);
    }
}
