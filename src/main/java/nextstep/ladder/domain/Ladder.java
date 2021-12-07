package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;

public class Ladder {
    private final Lines lines;

    private Ladder(Lines lines) {
        this.lines = lines;
    }

    public static Ladder from(Lines lines) {
        validateLines(lines);
        return new Ladder(lines);
    }

    private static void validateLines(Lines lines) {
        if (Objects.isNull(lines)) {
            throw new IllegalArgumentException();
        }
    }

    public int resultOfIndex(int index) {
        return lines.resultIndex(index);
    }

    public List<Line> getLines() {
        return lines.getLines();
    }
}
