package ladder.domain;

import java.util.List;
import java.util.Objects;

public class Ladder {

    private final Height height;
    private final List<Line> lines;

    public Ladder(Height height, List<Line> lines) {
        this.height = height;
        this.lines = lines;
    }

    public Height getHeight() {
        return height;
    }

    public List<Line> getLines() {
        return lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(height, ladder.height) && Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, lines);
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "height=" + height +
                ", lines=" + lines +
                '}';
    }

}
