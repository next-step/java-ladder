package laddergame.domain;

import java.util.List;
import java.util.Objects;

public class Ladder {

    private static final int MIN_INDEX_OF_HEIGHT = 0;

    private final List<LadderLine> lines;

    public Ladder(List<LadderLine> lines) {
        validate(lines);
        this.lines = lines;
    }

    private void validate(List<LadderLine> lines) {
        if (lines.isEmpty()) {
            return;
        }

        if (isNotSameAllLineWidth(lines)) {
            throw new IllegalArgumentException("사다리 가로 길이가 일치하지 않은 라인이 존재합니다.");
        }
    }

    private boolean isNotSameAllLineWidth(List<LadderLine> lines) {
        return countDistinctWidthOfLines(lines) != 1L;
    }

    private long countDistinctWidthOfLines(List<LadderLine> lines) {
        return lines.stream()
                .map(LadderLine::size)
                .distinct()
                .count();
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

    public int getWidth() {
        if (lines.isEmpty()) {
            return 0;
        }
        return lines.get(0).size();
    }

    public int moveToLastLine(int indexOfFirstPosition) {
        int indexOfCurrentPosition = indexOfFirstPosition;
        for (int i = 0; i < getHeight(); i++) {
            indexOfCurrentPosition = moveToNextLine(i, indexOfCurrentPosition);
        }
        return indexOfCurrentPosition;
    }

    public int moveToNextLine(int indexOfHeight, int indexOfPosition) {
        LadderLine line = getLine(indexOfHeight);
        LadderConnectedDirection direction = line.getConnectedDirection(indexOfPosition);
        return direction.getNextLinePosition(indexOfPosition);
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
