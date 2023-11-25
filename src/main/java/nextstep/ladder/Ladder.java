package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        validate(lines);
        this.lines = new ArrayList<>(lines);
    }

    public void validate(List<Line> lines) {
        checkLinesSizeIsValid(lines);
    }

    public void checkLinesSizeIsValid(List<Line> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException("라인은 최소 1개 이상이어야 합니다.");
        }

        for (Line line : lines) {
            line.validate(line.points());
        }
    }

    public List<Line> lines() {
        return this.lines;
    }
}
