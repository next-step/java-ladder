package ladder.domain;

import java.util.List;
import java.util.Objects;

public class LadderLine {
    private List<Line> lines;

    LadderLine(List<Line> lines) {
        this.lines = lines;
    }

    Line get(int index) {
        return lines.get(index);
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
