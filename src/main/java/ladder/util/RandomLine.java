package ladder.util;

import java.util.List;
import java.util.Random;

public class RandomLine {
    private static final Random RANDOM = new Random();

    public static boolean addPoint(int point, List<Boolean> points) {
        if (isPreviousTrue(point, points)) {
            return false;
        }
        return RANDOM.nextBoolean();
    }

    private static boolean isPreviousTrue(int point, List<Boolean> points) {
        return point > 0 && points.get(point - 1);
    }
}
