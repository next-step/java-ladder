package step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DefalutLineBuildStrategy implements LineBuildStrategy {
    private static final DefalutLineBuildStrategy defalutLineBuildStrategy = new DefalutLineBuildStrategy();
    private static final Random random = new Random();

    private DefalutLineBuildStrategy() {
    }

    @Override
    public List<Boolean> build(int countOfPerson) {
        List<Boolean> points = new ArrayList<>();
        for (int i = 0; i < countOfPerson - 1; i++) {
            points.add(makePoint(points, i));
        }
        return points;
    }

    private static boolean makePoint(List<Boolean> points, int index) {
        if (index != 0 && points.get(index - 1)) {
            return false;
        }
        return random.nextBoolean();
    }

    public static DefalutLineBuildStrategy getInstance() {
        return defalutLineBuildStrategy;
    }
}
