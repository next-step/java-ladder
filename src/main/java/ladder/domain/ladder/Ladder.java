package ladder.domain.ladder;

import java.util.List;
import java.util.Objects;

public class Ladder {

    private final List<HorizontalLine> lines;

    Ladder(List<HorizontalLine> lines) {
        this.lines = lines;
    }

    boolean isRight(int lineIndex, int pointIndex) {
        return lines.get(lineIndex).isRight(pointIndex);
    }

    int size() {
        return lines.size();
    }

    int lineSize() {
        return lines.get(0).size();
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
