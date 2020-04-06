package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines;
    private final Height heightOfLadder;

    public Ladder(List<Line> lines, int heightOfLadder) {
        validateLine(lines);

        this.lines = Collections.unmodifiableList(lines);
        this.heightOfLadder = new Height(heightOfLadder);
    }

    private void validateLine(List<Line> lines) {
        if (lines.size() < 2) {
            throw new IllegalArgumentException("라인은 두개 이상이여야 합니다.");
        }
    }

    public int getHeightOfLadder() {
        return heightOfLadder.getHeight();
    }

    public List<Line> getLines() {
        return lines;
    }
}
