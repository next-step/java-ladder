package nextstep.ladder.domain;

import java.util.Objects;
import nextstep.ladder.strategy.DrawLineStrategy;

public class LadderDrawingSettings {

    private final LadderSize ladderSize;
    private final DrawLineStrategy strategy;

    private LadderDrawingSettings(LadderSize ladderSize, DrawLineStrategy strategy) {
        this.ladderSize = Objects.requireNonNull(ladderSize);
        this.strategy = Objects.requireNonNull(strategy);
    }

    public static LadderDrawingSettings of(LadderSize ladderSize, DrawLineStrategy strategy) {
        return new LadderDrawingSettings(ladderSize, strategy);
    }

    public int getLadderWidth() {
        return ladderSize.getWidth();
    }

    public int getLadderHeight() {
        return ladderSize.getHeight();
    }

    public DrawLineStrategy getStrategy() {
        return strategy;
    }
}
