package ladder.domain;

import ladder.domain.exception.ContinuousTrueStickSameHeightException;
import ladder.domain.exception.DifferentLineSizeException;
import ladder.domain.exception.LinesLessThanMinimumSizeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private static final int DISTINCT_LINE_HEIGHT_COUNT = 1;
    private static final int MINIMUM_LINES_SIZE = 1;

    private final List<Line> lines;

    public Ladder(final List<Line> lines) {
        List<Line> nullSafeLines = Optional.ofNullable(lines)
                .orElse(new ArrayList<>());
        validate(nullSafeLines);
        this.lines = nullSafeLines;
    }

    public Ladder(LinesGenerable linesGenerable) {
        this(linesGenerable.generate());
    }

    private void validate(List<Line> lines) {
        validateMinimumLinesSize(lines);
        validateLinesAllSameHeight(lines);
        validateConsecutiveSticks(lines);
    }

    private void validateMinimumLinesSize(List<Line> lines) {
        if (lines.size() < MINIMUM_LINES_SIZE) {
            throw LinesLessThanMinimumSizeException.from(MINIMUM_LINES_SIZE);
        }
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
        IntStream.range(0, lines.size() - 1)
                .forEach(index -> checkConsecutiveLines(index, lines));
    }

    private void checkConsecutiveLines(int index, List<Line> lines) {
        Line line = lines.get(index);
        Line nextLine = lines.get(index + 1);
        List<Integer> indexes = line.findIndexesTrueStickOfSameIndex(nextLine);
        if (indexes.size() > 0) {
            throw ContinuousTrueStickSameHeightException.getInstance();
        }
    }

    public List<Stick> findSticksOf(LadderHeight height) {
        return lines.stream()
                .map(line -> line.findStickOf(height))
                .collect(Collectors.toList());
    }

    public LadderHeight findHeight() {
        return lines.stream()
                .findFirst()
                .map(Line::findHeight)
                .orElse(new LadderHeight(1));
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
