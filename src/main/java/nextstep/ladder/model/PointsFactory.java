package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PointsFactory {
    private static final int MIN_COUNT = 2;
    private static final Random RANDOM = new Random();

    private PointsFactory() {
    }

    public static List<Point> createBy(int countOfPerson) {
        if (countOfPerson < MIN_COUNT) {
            throw new IllegalArgumentException("최소 인원은 " + MIN_COUNT + "명 입니다");
        }

        List<Point> points = new ArrayList<>();
        points.add(Point.first(canConnect()));

        for (int i = 1; i <= countOfPerson - 2; i++) {
            Point before = points.get(i - 1);
            points.add(before.next(canConnect()));
        }

        Point beforeLast = points.get(points.size() - 1);
        points.add(beforeLast.last());

        return points;
    }

    private static boolean canConnect() {
        return RANDOM.nextBoolean();
    }
}
