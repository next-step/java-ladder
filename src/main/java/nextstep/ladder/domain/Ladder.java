package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;

public class Ladder {
    private static final String EMPTY_ERROR_MESSAGE = "Ladder 객체가 비어있습니다.";
    private static final String DIFFERENT_LINE_COUNT_ERROR_MESSAEG = "크기가 다른 라인객체가 존재합니다.";
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        validate(lines);
        this.lines = lines;
    }

    private void validate(List<Line> lines) {
        if (lines == null || lines.size() == 0) {
            throw new IllegalArgumentException(EMPTY_ERROR_MESSAGE);
        }

        for (Line line : lines) {
            if (!line.isSamePointSize(lines.get(0))) {
                throw new IllegalArgumentException(DIFFERENT_LINE_COUNT_ERROR_MESSAEG);
            }
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
