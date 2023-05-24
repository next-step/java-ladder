package ladder.domain.request;

import ladder.domain.Height;
import ladder.domain.Width;
import ladder.domain.strategy.GenerateStrategy;

public class LadderRequest {

    private final Height height;
    private final Width width;
    private final GenerateStrategy strategy;

    public LadderRequest(Height height, Width width, GenerateStrategy strategy) {
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

    public GenerateStrategy getStrategy() {
        return this.strategy;
    }

    public static LadderRequest of(Height height, Width width, GenerateStrategy strategy) {
        return new LadderRequest(height, width, strategy);
    }
}
