package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;

public class Line {
    private static final int MIN_LINE_SIZE = 1;

    private final List<Point> line;

    private Line(List<Point> line) {
        validateLine(line);
        this.line = line;
    }

    public static Line from(List<Point> line) {
        return new Line(line);
    }

    private static void validateLine(List<Point> line) {
        if (Objects.isNull(line) || line.size() < MIN_LINE_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public List<Point> getPoints() {
        return line;
    }
}
