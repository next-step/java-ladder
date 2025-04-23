package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {
    private final List<Line> lines;

    public Lines(int lineCount, int pointCount, RungGenerator generator) {
        validLadderLength(lineCount);
        validLadderLength(pointCount);
        this.lines = createLadder(lineCount, pointCount, generator);
    }

    public Lines(Line... lines) {
        this.lines = Arrays.asList(lines);
    }

    private void validLadderLength(int value) {
        if (value < 1)
            throw new IllegalArgumentException("The ladder height should be larger than zero.");
    }

    private List<Line> createLadder(int lineCount, int pointCount, RungGenerator generator) {
        return IntStream.range(0, lineCount)
                .mapToObj(i -> new Line(pointCount, generator))
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int moveLinesFrom(int startPoint) {
        return lines.stream()
                .reduce(startPoint,
                        (previousPoint, line) -> line.moveFrom(previousPoint),
                        (previousPoint, currentPoint) -> currentPoint);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lines lines1 = (Lines) o;
        return Objects.equals(lines, lines1.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lines);
    }
}
