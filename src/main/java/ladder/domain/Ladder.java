package ladder.domain;

import ladder.domain.exception.ContinuousStickSameHeightException;
import ladder.domain.exception.DifferentLineSizeException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Ladder {

    private static final int DISTINCT_LINE_HEIGHT_COUNT = 1;

    private final List<Line> lines;

    public Ladder(final List<Line> lines) {
        this.lines = lines;
        validate(lines);
    }

    public Ladder(LinesGenerable linesGenerable) {
        this(linesGenerable.generate());
    }

    private void validate(List<Line> lines) {
        validateLinesAllSameHeight(lines);
        validateConsecutiveSticks(lines);
    }

    private void validateLinesAllSameHeight(List<Line> lines) {
        long distinctLineHeightCount = lines.stream()
                .map(Line::findHeight)
                .distinct()
                .count();
        if (distinctLineHeightCount != DISTINCT_LINE_HEIGHT_COUNT) {
            throw DifferentLineSizeException.getInstance();
        }
    }
    
    private void validateConsecutiveSticks(List<Line> lines) {
        if (lines.size() <= 1) {
            return;
        }
        for (int index = 0; index < lines.size() - 1; index++) {
            checkConsecutiveLines(index, lines);
        }
    }

    private void checkConsecutiveLines(int index, List<Line> lines) {
        List<Integer> sameIndexes = findLine(index, lines).findIndexesBothTrue(findLine(index + 1, lines));
        if (sameIndexes.size() > 0) {
            throw ContinuousStickSameHeightException.getInstance();
        }
    }

    private Line findLine(int index, List<Line> lines) {
        return lines.get(index);
    }

    public List<Stick> findSticksOf(int height) {
        return lines.stream()
                .map(line -> line.findStickOf(height))
                .collect(Collectors.toList());
    }

    public int findHeight() {
        return lines.stream()
                .map(Line::findHeight)
                .findFirst()
                .orElse(0);
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
