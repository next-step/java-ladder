package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Line {

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line newInstance(List<Point> points) {
        validate(points);
        return new Line(points);
    }

    private static void validate(List<Point> points) {
        if (points == null) {
            throw new IllegalArgumentException("라인이 존재하지 않습니다.");
        }

        if (points.stream().anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("존재하지 않은 라인이 포함되어 있습니다.");
        }

        IntStream.range(1, points.size())
                .forEach(index -> points.get(index).validate(points.get(index - 1)));
    }

    public List<Point> toList() {
        return Collections.unmodifiableList(this.points);
    }
}
