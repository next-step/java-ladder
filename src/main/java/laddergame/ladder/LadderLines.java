package laddergame.ladder;

import java.util.List;
import java.util.Objects;

public class LadderLines {
    private final List<LadderLine> lines;

    public LadderLines(List<LadderLine> lines) {
        this.lines = lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderLines that = (LadderLines) o;
        return Objects.equals(lines, that.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
