package nextstep.ladder.domain;

import nextstep.ladder.strategy.DrawLineStrategy;

public class InterSpace {

    private final boolean hasCrossLine;

    public InterSpace(boolean hasCrossLine) {
        this.hasCrossLine = hasCrossLine;
    }

    public static InterSpace getBlankInterSpace() {
        return new InterSpace(false);
    }

    public static InterSpace draw(DrawLineStrategy strategy) {
        return new InterSpace(strategy.draw());
    }

    public boolean hasCrossLine() {
        return hasCrossLine;
    }
}
