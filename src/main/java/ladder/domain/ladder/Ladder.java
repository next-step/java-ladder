package ladder.domain.ladder;

import ladder.vo.Length;

import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private static final String LEFT_PADDING = "   ";
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        if (!isValidLines(lines)) {
            throw new IllegalArgumentException("All lines must be the same width");
        }

        this.lines = lines;
    }

    private boolean isValidLines(List<Line> lines) {
        long countOfUniqueWidth = lines.stream()
                .mapToInt(line -> {
                    Length width = line.getWidth();
                    return width.getValue();
                })
                .distinct()
                .count();

        return (1 == countOfUniqueWidth);
    }

    public Length getWidth() {
        Line firstLine = this.lines.get(0);
        return firstLine.getWidth();
    }

    public Length getHeight() {
        return new Length(this.lines.size());
    }

    @Override
    public String toString() {
        return this.lines.stream()
                .map(line -> LEFT_PADDING + line.toString())
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
