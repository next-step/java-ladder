package ladder.domain;

import ladder.strategy.LineCreationStrategy;

public class LineFactory {
    private final LineCreationStrategy strategy;

    public LineFactory(LineCreationStrategy strategy) {
        this.strategy = strategy;
    }

    public Line create(int width) {
        return new Line(strategy.hasHorizontalLine(width));
    }
}
