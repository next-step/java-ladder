package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
        validate();
    }

    private void validate() {
        if (lines == null || lines.size() == 0) {
            throw new IllegalArgumentException("Ladder 객체가 비어있습니다.");
        }

        for (Line line : lines) {
            if (!line.isSamePointSize(lines.get(0))) {
                throw new IllegalArgumentException("크기가 다른 라인객체가 존재합니다.");
            }
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
