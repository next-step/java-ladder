package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lines {
    private List<Line> lines;

    Lines() {
        this.lines = new ArrayList<>();
    }

    void append(final List<Line> lines) {
        this.lines.addAll(lines);
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
