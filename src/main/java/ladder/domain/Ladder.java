package ladder.domain;

import java.util.List;
import java.util.Objects;

public class Ladder {
    private final Lines lines;
    private final int height;

    public Ladder(final Lines lines, final int height) {
        this.lines = lines;
        this.height = height;
    }

    public List<Line> getLines() {
        return lines.get();
    }

    public int height() {
        return this.height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
