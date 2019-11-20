package ladder.domain;

import java.util.*;

public class LineShuffleGenerator implements LineGenerator {

    private static final int LADDER_BOUND_INDEX = 1;
    private static final int POINT_LAST_INDEX = 1;

    @Override
    public Line generate(int countOfPerson) {
        List<Boolean> points = new ArrayList<>();
        points.add(generateShufflePoint());
        for (int i = LADDER_BOUND_INDEX; i < countOfPerson - POINT_LAST_INDEX; i++) {
            Boolean currentPoints = points.stream()
                    .skip(points.size() - POINT_LAST_INDEX)
                    .map(this::checkPoint)
                    .findFirst()
                    .orElse(generateShufflePoint());
            points.add(currentPoints);
        }
        points.add(Boolean.FALSE);
        return new Line(points);
    }

    private Boolean checkPoint(Boolean type) {
        if (type) {
            return Boolean.FALSE;
        }
        return generateShufflePoint();
    }

    private Boolean generateShufflePoint() {
        return new Random().nextBoolean();
    }

}
