package ladder.domain.line;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Lines {

    private static final int MIN_COUNT = 1;

    private final List<Line> lines;

    private Lines(List<Line> lines) {
        this.lines = Optional.ofNullable(lines)
                .filter(this::isValidCount)
                .map(Collections::unmodifiableList)
                .orElseThrow(IllegalArgumentException::new);
    }

    private boolean isValidCount(List<Line> lines) {
        return MIN_COUNT <= lines.size();
    }

    public static Lines create(List<Line> lines) {
        return new Lines(lines);
    }

    public List<Line> getLines() {
        return lines;
    }
}
