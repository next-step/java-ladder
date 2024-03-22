package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Ladder {

    private static final String EMPTY_LADDER_EXCEPTION_MESSAGE = "사다리는 Line이 1개 이상 있어야 합니다";

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(List<Line> lines) {
        if (lines.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_LADDER_EXCEPTION_MESSAGE);
        }
        List<Line> unmodifiableLines = Collections.unmodifiableList(lines);
        return new Ladder(unmodifiableLines);
    }

    public List<Line> lines() {
        return lines;
    }
}
