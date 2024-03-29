package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomPointsGenerator {

    private static final Random RANDOM = new Random();

    public static List<Boolean> generate(int pointSize) {
        List<Boolean> points = new ArrayList<>();
        IntStream.range(0, pointSize)
                .forEach((index) -> addPoint(points, index));
        return Collections.unmodifiableList(points);
    }

    private static void addPoint(List<Boolean> points, int index) {
        if (isTruePreviousPoint(points, index)) {
            points.add(false);
            return;
        }
        points.add(RANDOM.nextBoolean());
    }


    private static boolean isTruePreviousPoint(List<Boolean> points, int index) {
        return index != 0 && points.get(index - 1);
    }

}
