package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;

public class Lines {

    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = List.copyOf(lines);
    }

    public List<Line> getAll() {
        return this.lines;
    }

    public int findEndPoint(int startPoint) {
        return lines.stream()
                .reduce(startPoint,
                        (point, line) -> point + line.calculatePoint(point),
                        Integer::sum);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lines lines1 = (Lines) o;
        return Objects.equals(lines, lines1.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }

}
