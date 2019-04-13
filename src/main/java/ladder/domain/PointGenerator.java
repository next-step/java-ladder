package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PointGenerator {
    public static final int OUT_SIDES = 1;
    public static double SEED_VALUE;

    public static List<Point> generate(int countOfPerson, Level level) {
        List<Point> points = new ArrayList<>(countOfPerson);
        SEED_VALUE = level.getSeed();
        initPoints(countOfPerson, points);
        return points;
    }


    private static void initPoints(int countOfPerson, List<Point> points) {
        points.add(Point.first());
        IntStream.range(0, countOfPerson - OUT_SIDES)
                .forEach(count -> points.add(points.get(count).next()));
    }

    public static boolean getRandomBoolean() {
        return Math.random() < SEED_VALUE;
    }

}
