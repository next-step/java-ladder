package ladder.model;

import java.util.*;
import java.util.stream.IntStream;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class LadderLine {
    private static final int MIN_POINT_COUNT = 1;
    private static final int INDEX_GAP_BETWEEN_NEXT_POINT = 1;
    private static final int SECOND_INDEX = 1;
    private static final Random random = new Random();

    private final List<Boolean> points;

    LadderLine(List<Boolean> points) {
        validateNotEmpty(points);
        validateNoOverlappingLine(points);
        this.points = points;
    }

    static LadderLine of(int pointCount) {
        validateMinPointCount(pointCount);
        return new LadderLine(generatePoints(pointCount));
    }

    private static List<Boolean> generatePoints(int pointCount) {
        Boolean firstPoint = random.nextBoolean();
        List<Boolean> points = new ArrayList<>(Collections.singletonList(firstPoint));

        IntStream.range(SECOND_INDEX, pointCount)
                .forEach(index -> {
                    if (points.get(index - INDEX_GAP_BETWEEN_NEXT_POINT) == TRUE) {
                        points.add(FALSE);
                        return;
                    }
                    Boolean randomPoint = random.nextBoolean();
                    points.add(randomPoint);
                });

        return points;
    }

    private void validateNotEmpty(List<Boolean> points) {
        if (points == null || points.isEmpty()) {
            throw new IllegalArgumentException("포인트 목록이 비었습니다.");
        }
    }

    private void validateNoOverlappingLine(List<Boolean> points) {
        IntStream.range(SECOND_INDEX, points.size())
                .filter(index -> points.get(index - INDEX_GAP_BETWEEN_NEXT_POINT) == TRUE && points.get(index) == TRUE)
                .findAny()
                .ifPresent(point -> {
                    throw new IllegalArgumentException("겹치는 라인이 존재하면 안됩니다.");
                });
    }

    private static void validateMinPointCount(int pointCount) {
        if (pointCount < MIN_POINT_COUNT) {
            throw new IllegalArgumentException(String.format("포인트 개수는 최소 %d개 이어야 합니다.", MIN_POINT_COUNT));
        }
    }
}
