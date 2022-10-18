package laddergame.domain;

import java.util.List;
import java.util.Objects;

public class Ladder {

    private static final int MIN_INDEX_OF_HEIGHT = 0;

    private final List<LadderLine> lines;

    public Ladder(List<LadderLine> lines) {
        this.lines = lines;
    }

    public LadderLine getLine(int indexOfHeight) {
        if (indexOfHeight < MIN_INDEX_OF_HEIGHT || indexOfHeight >= getHeight()) {
            throw new IndexOutOfBoundsException(indexOfHeight);
        }
        return lines.get(indexOfHeight);
    }

    public int getHeight() {
        return lines.size();
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
