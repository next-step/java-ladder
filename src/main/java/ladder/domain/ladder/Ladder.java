package ladder.domain.ladder;

import ladder.vo.Length;

public class Ladder {
    private Lines lines;

    public Ladder(Lines lines) {
        this.lines = lines;
    }

    Length getWidth() {
        return this.lines.getWidth();
    }

    Length getHeight() {
        return this.lines.getHeight();
    }
}
