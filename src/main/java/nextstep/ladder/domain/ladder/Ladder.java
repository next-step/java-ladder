package nextstep.ladder.domain.ladder;

import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines;
    private final static String INVALID_EMPTY_MESSAGE = "빈 List<Line>를 통해 Ladder을 생성할 수 없습니다.";

    public Ladder(List<Line> lines) {
        checkInvalidLines(lines);
        this.lines = lines;
    }

    private void checkInvalidLines(List<Line> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException(INVALID_EMPTY_MESSAGE);
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
