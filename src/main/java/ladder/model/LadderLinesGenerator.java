package ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public abstract class LadderLinesGenerator {
    protected static final int FIRST_INDEX = 0;
    protected static final int LAST_POINT_COUNT = 1;
    private static final int SUM_OF_FIRST_AND_LAST_POINT_COUNT = 2;
    private static final int INDEX_GAP_BETWEEN_NEXT_POINT = 1;
    private static final int GAP_BETWEEN_LAST_INDEX_AND_SIZE = 1;
    private static final int GAP_BETWEEN_POINT_COUNT_AND_POINT_VALUE_COUNT = 1;
    private static final Random random = new Random();

    public abstract List<LadderLine> generate(int ladderHeight, int pointCount);

    protected static List<LadderPoint> generateRandomPoints(int pointCount) {
        LadderPoint firstPoint = LadderPoint.first();
        List<LadderPoint> points = new ArrayList<>(Collections.singletonList(firstPoint));

        int pointCountExcludingFirstAndLastPoint = pointCount - SUM_OF_FIRST_AND_LAST_POINT_COUNT;
        IntStream.range(FIRST_INDEX, pointCountExcludingFirstAndLastPoint)
                .forEach(index -> {
                    LadderPoint point = points.get(index);
                    points.add(point.next());
                });

        int currentLastIndex = points.size() - GAP_BETWEEN_LAST_INDEX_AND_SIZE;
        LadderPoint currentLastPoint = points.get(currentLastIndex);
        points.add(currentLastPoint.last());

        return points;
    }

    protected static List<LadderPoint> generatePoints(int pointCount, List<Integer> pointIndicesWithTrueRight) {
        int pointValueCount = pointCount - GAP_BETWEEN_POINT_COUNT_AND_POINT_VALUE_COUNT;
        List<Boolean> pointValues = generateRandomPointValues(pointValueCount);

        pointIndicesWithTrueRight.forEach(pointIndex -> {
            int previousIndex = pointIndex - INDEX_GAP_BETWEEN_NEXT_POINT;
            int nextIndex = pointIndex + INDEX_GAP_BETWEEN_NEXT_POINT;

            if (previousIndex >= FIRST_INDEX) {
                pointValues.set(previousIndex, FALSE);
            }

            if (nextIndex < pointValueCount) {
                pointValues.set(nextIndex, FALSE);
            }

            pointValues.set(pointIndex, TRUE);
        });

        return generatePoints(pointValues);
    }

    private static List<LadderPoint> generatePoints(List<Boolean> pointValues) {
        Boolean rightOfFirstPoint = pointValues.get(FIRST_INDEX);
        LadderPoint firstPoint = LadderPoint.first(rightOfFirstPoint);
        List<LadderPoint> points = new ArrayList<>(Collections.singletonList(firstPoint));

        int pointCountExcludingLastPoint = pointValues.size() - LAST_POINT_COUNT;
        IntStream.range(FIRST_INDEX, pointCountExcludingLastPoint)
                .forEach(index -> {
                    int nextIndex = index + INDEX_GAP_BETWEEN_NEXT_POINT;

                    boolean left = pointValues.get(index);
                    boolean right = pointValues.get(nextIndex);

                    LadderPoint point = new LadderPoint(nextIndex, new LadderDirection(left, right));
                    points.add(point);
                });

        int currentLastIndex = points.size() - GAP_BETWEEN_LAST_INDEX_AND_SIZE;
        LadderPoint currentLastPoint = points.get(currentLastIndex);
        points.add(currentLastPoint.last());

        return points;
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
        if (TRUE == previousPoint) {
            return FALSE;
        }
        return random.nextBoolean();
    }

    protected List<LadderLine> shuffled(List<LadderLine> lines) {
        Collections.shuffle(lines);
        return lines;
    }
}
