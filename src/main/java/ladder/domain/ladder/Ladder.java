package ladder.domain.ladder;

import ladder.vo.Length;

public class Ladder {
    private Lines lines;

    public Ladder(Lines lines) {
        this.lines = lines;
    }

    public Length getWidth() {
        return this.lines.getWidth();
    }

    public Length getHeight() {
        return this.lines.getHeight();
    }
}
