package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private final List<Boolean> points = new ArrayList<>();

    public Line(List<Boolean> points) {
        validateExistSequentialLine(points);
        this.points.addAll(points);
    }

    private void validateExistSequentialLine(List<Boolean> points) {
        IntStream.range(1, points.size())
                .forEach((i) -> validateSequential(points, i));
    }

    private void validateSequential(List<Boolean> points, int idx) {
        if (points.get(idx - 1) && points.get(idx)) {
            throw new IllegalArgumentException("라인은 연속으로 겹치면 안됩니다.");
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public int move(int idx) {
        if (idx == points.size() && points.get(idx - 1)) {
            return idx - 1;
        }
        if (idx == points.size() && !points.get(idx - 1)) {
            return idx;
        }
        if (idx == 0 && points.get(idx)) {
            return idx + 1;
        }
        if (idx == 0 && !points.get(idx)) {
            return idx;
        }

        if (points.get(idx)) {
            return idx + 1;
        }
        if (points.get(idx - 1)) {
            return idx - 1;
        }
        return idx;
    }
}
