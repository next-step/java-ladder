package ladder.domain;

import java.util.*;

public class PointsShuffleGenerator implements PointsGenerator {
    private static final String EXCEPTION_MSG = "초기값 에러";
    private static final int LADDER_BOUND_INDEX = 1;
    private static final int INDEX = 0;

    @Override
    public List<Boolean> generate(int countOfPerson) {
        List<Boolean> points = new ArrayList<>();
        points.add(generateShufflePoint());
        for (int i = LADDER_BOUND_INDEX; i < countOfPerson - LADDER_BOUND_INDEX; i++) {
            boolean currentPoints = points.stream()
                    .reduce((a, b) -> b)
                    .map(this::generatePoints)
                    .orElseThrow(() -> new IllegalArgumentException(EXCEPTION_MSG));
            points.add(currentPoints);
        }
        return points;
    }

    private boolean generatePoints(boolean currentBoolean) {
        if (currentBoolean) {
            return false;
        }
        return generateShufflePoint();
    }

    private boolean generateShufflePoint() {
        List<Boolean> booleans = Arrays.asList(true, false);
        Collections.shuffle(booleans);
        return booleans.get(INDEX);
    }
}
