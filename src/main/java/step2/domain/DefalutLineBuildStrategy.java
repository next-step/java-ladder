package step2.domain;

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
            if (i != 0 && points.get(i - 1)) {
                points.add(false);
                continue;
            }
            points.add(random.nextBoolean());
        }
        return points;
    }

    public static DefalutLineBuildStrategy getInstance() {
        return defalutLineBuildStrategy;
    }
}
