package ladder.domain;

import java.util.List;
import java.util.Objects;

public class Ladder {
    private Height height;
    private List<Line> lines;

    public Ladder(final Height height) {
        this.lines = createLines(height);
        this.height = height;
    }

    public List<Line> lines() {
        return lines;
    }

    private List<Line> createLines(final Height height) {
        return null;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Ladder ladder = (Ladder) o;
        return Objects.equals(height, ladder.height) &&
                Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, lines);
    }
}
