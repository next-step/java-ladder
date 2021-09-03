package nextstep.ladder.domain;

import nextstep.ladder.strategy.DrawLineStrategy;

public class LadderColumn {

    private final boolean hasLeg;

    public LadderColumn(boolean hasLeg) {
        this.hasLeg = hasLeg;
    }

    public LadderColumn() {
        this(false);
    }

    public static LadderColumn drawVerticalLine(DrawLineStrategy strategy) {
        return new LadderColumn(strategy.drawLine());
    }

    public boolean hasLeg() {
        return hasLeg;
    }
}
