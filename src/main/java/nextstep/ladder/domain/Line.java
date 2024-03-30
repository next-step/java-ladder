package nextstep.ladder.domain;

import nextstep.ladder.exception.LineConsecutivePointException;

import java.util.List;
import java.util.stream.IntStream;

public class Line {

    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        validateConsecutivePoint(points);
        this.points = points;
    }

    private static void validateConsecutivePoint(List<Boolean> points) {
        if (hasConsecutivePoint(points)) {
            throw new LineConsecutivePointException(points);
        }
    }

    private static boolean hasConsecutivePoint(List<Boolean> points) {
        return IntStream.range(1, points.size())
                .anyMatch(index -> points.get(index - 1) && points.get(index));
    }

    public List<Boolean> get() {
        return this.points;
    }

}
