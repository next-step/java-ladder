package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLadderGenerator implements LadderGenerator {
    private static int FIRST_INDEX = 0;
    private static final int LAST_POINT_COUNT = 1;
    private static final Random random = new Random();

    public List<Line> generate(int height, int width) {
        return IntStream.range(FIRST_INDEX, height)
                .mapToObj(n ->
                        new Line(generateRandomPointValues(width - 1))
                ).collect(Collectors.toList());
    }

    private static List<Boolean> generateRandomPointValues(int pointValueCount) {
        Boolean firstPoint = random.nextBoolean();
        List<Boolean> points = new ArrayList<>(Collections.singletonList(firstPoint));

        int pointValueCountExcludingLastPointValue = pointValueCount - LAST_POINT_COUNT;
        IntStream.range(FIRST_INDEX, pointValueCountExcludingLastPointValue)
                .forEach(index -> {
                    Boolean previousPoint = points.get(index);
                    points.add(generateRandomPointValue(previousPoint));
                });

        return points;
    }

    private static Boolean generateRandomPointValue(Boolean previousPoint) {
        if (previousPoint == true) {
            return false;
        }
        return random.nextBoolean();
    }

}
