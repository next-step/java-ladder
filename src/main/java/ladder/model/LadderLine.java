package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {
    private final List<Boolean> points;

    LadderLine(List<Boolean> points) {
        validateNotEmpty(points);
        this.points = points;
    }

    static LadderLine of(int pointCount) {
        return new LadderLine(new ArrayList<>());
    }

    private void validateNotEmpty(List<Boolean> points) {
        if (points == null || points.isEmpty()) {
            throw new IllegalArgumentException("포인트 목록이 비었습니다.");
        }
    }
}
