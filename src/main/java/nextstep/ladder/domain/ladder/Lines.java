package nextstep.ladder.domain.ladder;

import java.util.List;

public class Lines {
    private final List<Line> lines;
    private final static String INVALID_EMPTY_MESSAGE = "빈 List<Line>를 통해 Lines을 생성할 수 없습니다.";

    public Lines(List<Line> lines) {
        checkInvalidLines(lines);
        this.lines = lines;
    }

    private void checkInvalidLines(List<Line> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException(INVALID_EMPTY_MESSAGE);
        }
    }
}
