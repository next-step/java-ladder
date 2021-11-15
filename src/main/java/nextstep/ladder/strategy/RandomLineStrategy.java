package nextstep.ladder.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomLineStrategy implements LineStrategy {
    private static final Random RANDOM = new Random();
    private static final Integer START_POINT_INDEX = 1;
    private static final Integer PREVIOUS_POINT_INDEX = -1;

    @Override
    public List<Boolean> createPoints(int countOfPerson) {
        List<Boolean> points = new ArrayList<>(Collections.nCopies(countOfPerson, false));

        IntStream.range(START_POINT_INDEX, countOfPerson)
                .forEach(index -> {
                    boolean previousPoint = points.get(index + PREVIOUS_POINT_INDEX);
                    points.set(index, nextPoint(previousPoint));
                });
        return points;
    }

    private boolean nextPoint(boolean previousPoint) {
        if (previousPoint) {
            return false;
        }
        return RANDOM.nextBoolean();
    }
}
