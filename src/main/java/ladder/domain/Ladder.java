package ladder.domain;

import java.util.List;

public class Ladder {

    private static final String EMPTY_LADDER_EXCEPTION_MESSAGE = "사다리는 Line이 1개 이상 있어야 합니다";

    private final Lines lines;

    private Ladder(List<Line> lines) {
        this(Lines.from(lines));
    }

    private Ladder(Lines lines) {
        this.lines = lines;
    }

    public static Ladder from(List<Line> lines) {
        if (lines.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_LADDER_EXCEPTION_MESSAGE);
        }
        return new Ladder(lines);
    }

    public List<Line> lines() {
        return lines.value();
    }
}
