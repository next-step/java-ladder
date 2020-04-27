package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LineGenerator {
    private static final int INDEX_DIFFERENCE = 1;
    private static final Random random = new Random();

    public static List<Boolean> generateRandomPoints(int count) {
        List<Boolean> points = new ArrayList<>();

        for (int index = 0; index < count; index++) {
            points.add(generatePointValue(isPreviousPointExist(points, index)));
        }

        return points;
    }

    private static boolean generatePointValue(boolean isPreviousExist) {
        if (isPreviousExist) {
            return false;
        }

        return random.nextBoolean();
    }

    private static boolean isPreviousPointExist(List<Boolean> points, int index) {
        return index != 0 && points.get(index - INDEX_DIFFERENCE);
    }
}
