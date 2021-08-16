package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {
    private static final int MIN_POINT_COUNT = 1;

    private final List<Boolean> points;

    LadderLine(List<Boolean> points) {
        this.points = points;
    }

    static LadderLine of(int pointCount) {
        validateMinPointCount(pointCount);
        return new LadderLine(new ArrayList<>());
    }

    private static void validateMinPointCount(int pointCount) {
        if (pointCount < MIN_POINT_COUNT) {
            throw new IllegalArgumentException(String.format("포인트 개수는 최소 %d개 이어야 합니다.", MIN_POINT_COUNT));
        }
    }
}
