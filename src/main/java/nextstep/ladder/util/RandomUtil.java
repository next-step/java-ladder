package nextstep.ladder.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomUtil {

    private static final Random random = new Random();

    public static List<Boolean> generatorPoints(int count) {
        List<Boolean> points = new ArrayList<>();
        IntStream.range(0, count)
                .forEach(index -> addPoint(points, index, random.nextBoolean()));
        return points;
    }

    private static void addPoint(List<Boolean> points, int index, boolean point) {
        if (index == 0 || !points.get(index - 1)) {
            points.add(point);
            return;
        }
        points.add(false);
    }

}
