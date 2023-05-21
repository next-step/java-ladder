package ladder.domain.request;

import ladder.domain.Height;
import ladder.domain.Width;
import ladder.domain.strategy.LadderStrategy;

public class LadderRequest {

    private final Height height;
    private final Width width;
    private final LadderStrategy strategy;

    public LadderRequest(Height height, Width width, LadderStrategy strategy) {
        this.height = height;
        this.width = width;
        this.strategy = strategy;
    }

    public int getHeight() {
        return height.getHeight();
    }

    public Width getWidth() {
        return this.width;
    }

    public LadderStrategy getStrategy() {
        return this.strategy;
    }

    public static LadderRequest of(Height height, Width width, LadderStrategy strategy) {
        return new LadderRequest(height, width, strategy);
    }
}
