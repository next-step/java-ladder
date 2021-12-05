package nextstep.step2.vo;

import nextstep.step2.domain.Line;
import nextstep.step2.domain.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lines {

    private static final String EMPTY_MESSAGE = "Line 은 최대 한줄 이상입니다.";

    private final List<Line> lines;

    private Lines(List<Line> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_MESSAGE);
        }
        this.lines = new ArrayList<>(lines);
    }

    public static Lines of(List<Line> lines) {
        return new Lines(lines);
    }

    public List<Line> getLines() {
        return lines.stream()
                .map(Line::of)
                .collect(Collectors.toList());
    }

    public Point movedPoint(Point start) {
        Point now = Point.of(start);
        for (Line line : lines) {
            now = line.move(now);
        }
        return now;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lines lines1 = (Lines) o;
        return Objects.equals(lines, lines1.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
