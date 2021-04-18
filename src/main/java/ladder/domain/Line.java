package ladder.domain;

import ladder.exception.PointListNullPointerException;
import ladder.strategy.LineGenerateStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class Line {

    private static final int ZERO = 0;
    private static final int ONE = 1;

    private final List<Point> points;

    private Line(List<Point> points) {
        validateNull(points);
        this.points = points;
    }

    private final void validateNull(List<Point> points) {
        if (Objects.isNull(points)) {
            throw new PointListNullPointerException();
        }
    }

    public static final Line of(List<Point> points) {
        return new Line(points);
    }

    public final Stream<Point> stream() {
        return points.stream();
    }

    public final void run(List<Integer> list) {
        int beforePosition = list.get(ZERO);
        for (int index = ONE; index < list.size(); index++) {
            int nowPosition = list.get(index);
            if (points.get(index).hasPoint()) {
                list.set(index - ONE, nowPosition);
                list.set(index, beforePosition);
                continue;
            }
            beforePosition = nowPosition;
        }
    }
}
