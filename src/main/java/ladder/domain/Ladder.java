package ladder.domain;

import java.util.List;
import java.util.Objects;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return lines;
    }

    public int move(int position) {
        int current = position;
        for (Line line : lines) {
            current = line.move(current);
        }

        return current;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder1 = (Ladder) o;
        return Objects.equals(lines, ladder1.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
