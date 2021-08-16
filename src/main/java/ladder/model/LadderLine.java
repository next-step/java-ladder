package ladder.model;

import java.util.*;
import java.util.stream.IntStream;

import static java.lang.Boolean.TRUE;

public class LadderLine {
    private static final Random random = new Random();
    private static final int MIN_POINT_COUNT = 1;

    private final List<Boolean> points;

    LadderLine(List<Boolean> points) {
        validateNotEmpty(points);
        validateNoOverlappingLine(points);
        this.points = points;
    }

    static LadderLine of(int pointCount) {
        validateMinPointCount(pointCount);
        return new LadderLine(new ArrayList<>());
    }

    private void validateNotEmpty(List<Boolean> points) {
        if (points == null || points.isEmpty()) {
            throw new IllegalArgumentException("포인트 목록이 비었습니다.");
        }
    }

    private void validateNoOverlappingLine(List<Boolean> points) {
        IntStream.range(0, points.size() - 1)
                .filter(index -> points.get(index) == TRUE && points.get(index + 1) == TRUE)
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
