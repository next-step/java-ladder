package ladder.domain.ladder;

import java.util.List;

public class Lines {
    private final List<Line> lines;
    private static final int NUMBER_OF_UNIQUE_WIDTHS = 1;

    public Lines(List<Line> lines) {
        validateLines(lines);

        this.lines = lines;
    }

    private void validateLines(List<Line> lines) {
        if (NUMBER_OF_UNIQUE_WIDTHS != getNumberOfUniqueWidths(lines)) {
            throw new IllegalArgumentException("Every line must has the same width");
        }
    }

    private long getNumberOfUniqueWidths(List<Line> lines) {
        return lines.stream()
                    .mapToInt(Line::getWidth)
                    .distinct()
                    .count();
    }
}
