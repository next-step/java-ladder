package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

// 요구 사항에서 Line이 point를 관리하라고 되어있는데, 그러면 이거 없애야 하나요?
public class PointGenerator {
    public static final int OUT_SIDES = 1;
    public static double SEED_VALUE;

    public static List<Point> generate(int countOfPerson, LEVEL level) {
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
