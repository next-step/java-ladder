package laddergame.domain;

import java.util.List;
import java.util.Objects;

public class Ladder {

    private final List<LadderLine> lines;

    public Ladder(List<LadderLine> lines) {
        this.lines = lines;
    }

    public int getHeight() {
        return lines.size();
    }

    public LadderLine getLine(int index) {
        return lines.get(index);
    }

    public int moveToLastLine(int index) {
        int lastIndex = index;
        for (LadderLine line : lines) {
            Point point = line.get(lastIndex);
            lastIndex = point.getNextLineIndex();
        }
        return lastIndex;
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

    @Override
    public String toString() {
        return "Ladder{" +
                "lines=" + lines +
                '}';
    }

}
