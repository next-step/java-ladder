package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.lang.Boolean.TRUE;

public class LadderLine {
    private final List<Boolean> points;

    LadderLine(List<Boolean> points) {
        validateNotEmpty(points);
        validateNoOverlappingLine(points);
        this.points = points;
    }

    private void validateNoOverlappingLine(List<Boolean> points) {
        IntStream.range(0, points.size() - 1)
                .filter(index -> points.get(index) == TRUE && points.get(index + 1) == TRUE)
                .findAny()
                .ifPresent(point -> {
                    throw new IllegalArgumentException("겹치는 라인이 존재하면 안됩니다.");
                });
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
