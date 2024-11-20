package nextstep.ladder.domain;


import static nextstep.ladder.domain.ConsecutiveChecker.isConsecutive;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lines {

    private final List<Line> lines;

    public Lines(List<Boolean> lines) {
        if (isConsecutive(lines)) {
            throw new IllegalStateException("연속되는 숫자 입니다");
        }
        this.lines = PointConverter.convert(lines);
    }

    public List<Boolean> getPoint() {
        return lines.stream().map(Line::canMove).collect(Collectors.toList());
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

    private static class PointConverter {
        private static List<Line> convert(List<Boolean> points) {
            return toPoints(points);
        }

        private static List<Line> toPoints(List<Boolean> lines) {
            ArrayList<Line> result = new ArrayList<>();
            for (int i = 0; i < lines.size(); i++) {
                result.add(new Line(lines.get(i), i));
            }
            return result;
        }
    }
}
