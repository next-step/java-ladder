package nextstep.ladder.domain;

import nextstep.ladder.exception.LineDuplicateException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        validatePointsContinuity(points);
        this.points = new ArrayList<>(points);
    }

    private void validatePointsContinuity(List<Boolean> points) {
        IntStream.range(0, points.size() - 1)
                .filter(i -> points.get(i) && points.get(i + 1))
                .findFirst()
                .ifPresent(i -> {throw new LineDuplicateException();});
    }

    public int size() {
        return points.size();
    }

    public List<Boolean> points() {
        return points;
    }
}
