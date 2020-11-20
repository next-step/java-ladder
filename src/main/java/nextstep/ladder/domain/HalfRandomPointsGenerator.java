package nextstep.ladder.domain;

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
    public List<Boolean> getPoints(NumberOfParticipants numberOfParticipants) {
        List<Boolean> points = new ArrayList<>(numberOfParticipants.getPointsSize());
        points.add(RANDOM.nextBoolean());

        IntStream.range(1, numberOfParticipants.getPointsSize())
                .forEach(index -> {
                    Boolean prevPoint = points.get(index - 1);
                    points.add(prevPoint ? false : RANDOM.nextBoolean());
                });
        return points;
    }
}
