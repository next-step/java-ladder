package nextstep.ladder.domain;

import java.util.Objects;
import nextstep.ladder.strategy.DrawLineStrategy;

public class LadderGameSettings {

    private final LadderSize ladderSize;
    private final DrawLineStrategy strategy;


    private LadderGameSettings(LadderSize ladderSize, DrawLineStrategy strategy) {
        this.ladderSize = Objects.requireNonNull(ladderSize);
        this.strategy = Objects.requireNonNull(strategy);
    }

    public static LadderGameSettings of(LadderSize ladderSize, DrawLineStrategy strategy) {
        return new LadderGameSettings(ladderSize, strategy);
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
