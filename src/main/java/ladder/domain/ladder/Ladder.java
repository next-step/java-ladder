package ladder.domain.ladder;

import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private static final String LEFT_PADDING = "  ";
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    @Override
    public String toString() {
        return this.lines.stream()
                .map(line -> LEFT_PADDING + line.toString())
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
