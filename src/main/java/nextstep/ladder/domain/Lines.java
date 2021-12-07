package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;

public class Lines {
    private static final int MIN_LINES_SIZE = 1;

    private final List<Line> lines;

    private Lines(List<Line> lines) {
        validateLines(lines);
        this.lines = lines;
    }

    private static void validateLines(List<Line> lines) {
        if (Objects.isNull(lines) || lines.size() < MIN_LINES_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public static Lines from(List<Line> lines) {
        return new Lines(lines);
    }

    public int resultIndex(int index) {
        for (Line line : lines) {
            index = line.move(index);
        }
        return index;
    }

    public List<Line> getLines() {
        return lines;
    }
}
