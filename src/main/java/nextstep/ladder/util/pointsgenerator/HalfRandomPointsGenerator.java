package nextstep.ladder.util.pointsgenerator;

import java.util.Random;

public class HalfRandomPointsGenerator implements PointsGenerator {
    private static final HalfRandomPointsGenerator INSTANCE = new HalfRandomPointsGenerator();
    private static final Random RANDOM = new Random();

    private HalfRandomPointsGenerator() {
    }

    public static HalfRandomPointsGenerator getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean generatePoint() {
        return RANDOM.nextBoolean();
    }
}
