package nextstep.ladder.util.pointsgenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class HalfRandomPointsGenerator implements PointsGenerator {
    private static final HalfRandomPointsGenerator INSTANCE = new HalfRandomPointsGenerator();
    private static final Random RANDOM = new Random();

    private HalfRandomPointsGenerator() {
    }

    public static HalfRandomPointsGenerator getInstance() {
        return INSTANCE;
    }

    @Override
    public List<Boolean> getPoints(int pointsSize) {
        List<Boolean> points = new ArrayList<>(pointsSize);
        points.add(RANDOM.nextBoolean());

        IntStream.range(1, pointsSize)
                .forEach(index -> {
                    Boolean prevPoint = points.get(index - 1);
                    points.add(prevPoint ? false : RANDOM.nextBoolean());
                });
        return points;
    }

    @Override
    public boolean generatePoint() {
        return RANDOM.nextBoolean();
    }
}
