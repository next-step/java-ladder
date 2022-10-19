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

    public int moveNextLine(int indexOfHeight, int indexOfPosition) {
        if (isConnectedRight(indexOfHeight, indexOfPosition)) {
            return indexOfPosition + 1;
        }

        if (isConnectedLeft(indexOfHeight, indexOfPosition)) {
            return indexOfPosition - 1;
        }

        return indexOfPosition;
    }

    private boolean isConnectedRight(int indexOfHeight, int indexOfPosition) {
        LadderLine line = getLine(indexOfHeight);
        if (indexOfPosition == line.size()) {
            return false;
        }
        return line.isConnected(indexOfPosition);
    }

    private boolean isConnectedLeft(int indexOfHeight, int indexOfPosition) {
        LadderLine line = getLine(indexOfHeight);
        if (indexOfPosition == 0) {
            return false;
        }
        return line.isConnected(indexOfPosition - 1);
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
