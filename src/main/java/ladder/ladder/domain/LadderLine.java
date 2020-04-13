package ladder.ladder.domain;

import java.util.List;
import java.util.Objects;

public class LadderLine {
    private List<Line> lines;

    private LadderLine(List<Line> lines) {
        this.lines = lines;
    }

    public static LadderLine of(List<Line> lines) {
        return new LadderLine(lines);
    }

    public List<Line> getLines() {
        return lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderLine)) return false;
        LadderLine that = (LadderLine) o;
        return Objects.equals(lines, that.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }

    @Override
    public String toString() {
        return "LadderLine{" +
                "lines=" + lines +
                '}';
    }
}
