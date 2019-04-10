package ladder.domain.ladder;

import ladder.vo.Length;
import ladder.vo.coordinate.Coordinate;

import java.util.List;
import java.util.stream.Collectors;

public class Lines {
    private static final int NUMBER_OF_UNIQUE_WIDTHS = 1;

    private final List<Line> lines;

    public Lines(List<Line> lines) {
        validateLines(lines);

        this.lines = lines;
    }

    public Length getWidth() {
        return this.lines.get(0).getWidth();
    }

    public Length getHeight() {
        int height = this.lines.size();
        return new Length(height);
    }

    Coordinate cross(Coordinate coordinate) {
        Line line = this.lines.get(getLineIndex(coordinate));

        return line.cross(coordinate)
                .down();
    }

    private void validateLines(List<Line> lines) {
        if (NUMBER_OF_UNIQUE_WIDTHS != getNumberOfUniqueWidths(lines)) {
            throw new IllegalArgumentException("Every line must has the same width");
        }
    }

    private long getNumberOfUniqueWidths(List<Line> lines) {
        return lines.stream()
                    .map(Line::getWidth)
                    .distinct()
                    .count();
    }

    private int getLineIndex(Coordinate coordinate) {
        return this.lines.size() - coordinate.getYValue();
    }

    @Override
    public String toString() {
        return this.lines.stream()
                .map(Line::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
