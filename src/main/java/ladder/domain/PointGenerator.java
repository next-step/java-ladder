package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PointGenerator {
    public static final int OUT_SIDES = 1;
    public static final double SEED_VALUE = 0.5;

    public static List<Point> generate(int countOfPerson) {
        List<Point> points = new ArrayList<>(countOfPerson);
        initPoints(countOfPerson, points);
        return points;
    }

    private static void initPoints(int countOfPerson, List<Point> points) {
        points.add(Point.first(getRandomBoolean()));
        IntStream.range(0, countOfPerson - OUT_SIDES)
                .forEach(count -> points.add(points.get(count).next(getRandomBoolean())));
    }

    private static boolean getRandomBoolean() {
        return Math.random() < SEED_VALUE;
    }

}
