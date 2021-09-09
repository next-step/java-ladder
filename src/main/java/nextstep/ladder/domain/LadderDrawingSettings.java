package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;
import nextstep.ladder.strategy.DrawLineStrategy;

public class LadderDrawingSettings {

    private final LadderSize ladderSize;
    private final LadderLabels ladderLabels;
    private final DrawLineStrategy strategy;


    private LadderDrawingSettings(LadderSize ladderSize, LadderLabels ladderLabels,  DrawLineStrategy strategy) {
        this.ladderSize = Objects.requireNonNull(ladderSize);
        this.ladderLabels = Objects.requireNonNull(ladderLabels);
        this.strategy = Objects.requireNonNull(strategy);
    }

    public static LadderDrawingSettings of(LadderSize ladderSize, LadderLabels ladderLabels, DrawLineStrategy strategy) {
        return new LadderDrawingSettings(ladderSize, ladderLabels, strategy);
    }

    public int getLadderWidth() {
        return ladderSize.getWidth();
    }

    public int getLadderHeight() {
        return ladderSize.getHeight();
    }

    public List<String> getPlayerNames() {
        return ladderLabels.getPlayerNames();
    }

    public List<String> getPrizeNames() {
        return ladderLabels.getPrizeNames();
    }

    public DrawLineStrategy getStrategy() {
        return strategy;
    }
}
