package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;

public class Lines {

    private final List<Line> lines;

    public Lines(LineFactory height, Point point) {
        this(height.generateLines(point));
    }

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lines)) return false;
        Lines lines1 = (Lines) o;
        return Objects.equals(lines, lines1.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
