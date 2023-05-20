package step2.domain;

import java.util.Random;

public class DefalutLineBuildStrategy implements LineBuildStrategy {
    private static final DefalutLineBuildStrategy defalutLineBuildStrategy = new DefalutLineBuildStrategy();
    private static final Random random = new Random();

    private DefalutLineBuildStrategy() {
    }

    @Override
    public boolean build() {
        return random.nextBoolean();
    }

    public static DefalutLineBuildStrategy getInstance() {
        return defalutLineBuildStrategy;
    }
}
