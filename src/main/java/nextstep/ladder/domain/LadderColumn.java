package nextstep.ladder.domain;

import nextstep.ladder.strategy.DrawLineStrategy;

public class LadderColumn {

    private final boolean hasHorizontalLine;

    public LadderColumn() {
        this(false);
    }

    private LadderColumn(boolean hasHorizontalLine) {
        this.hasHorizontalLine = hasHorizontalLine;
    }

    public LadderColumn drawLine(DrawLineStrategy strategy) {
        return new LadderColumn(strategy.drawLine());
    }

    public boolean value() {
        return hasHorizontalLine;
    }
}
