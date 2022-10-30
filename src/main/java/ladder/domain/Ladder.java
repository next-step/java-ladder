package ladder.domain;

import ladder.domain.exception.ContinuousStickSameHeightException;
import ladder.domain.exception.DifferentLineSizeException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Ladder {

    private static final int NON_OVERLAPPING_LINE_SIZE_COUNT = 1;

    private final List<Line> lines;

    public Ladder(final List<Line> lines) {
        this.lines = lines;
        validateLineSize();
        validateConsecutiveSticks(lines);
    }

    private void validateLineSize() {
        int nonOverlappingLineSizeCount = (int) lines.stream()
                .map(Line::findSize)
                .distinct()
                .count();
        if (nonOverlappingLineSizeCount != NON_OVERLAPPING_LINE_SIZE_COUNT) {
            throw DifferentLineSizeException.getInstance();
        }
    }
    
    private void validateConsecutiveSticks(List<Line> lines) {
        if (lines.size() <= 1) {
            return;
        }
        for (int i = 0; i < lines.size() - 1; i++) {
            checkConsecutiveLines(i);
        }
    }

    private void checkConsecutiveLines(int index) {
        List<Integer> sameIndexes = findLine(index).findIndexesBothTrue(findLine(index + 1));
        if (sameIndexes.size() > 0) {
            throw ContinuousStickSameHeightException.getInstance();
        }
    }

    private Line findLine(int index) {
        return lines.get(index);
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
