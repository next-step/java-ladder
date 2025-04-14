package ladder.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import ladder.exception.LadderInvalidException;
import ladder.strategy.LineCreationStrategy;
import ladder.strategy.LineRandomStrategy;

public class LineFactory {
    private static final int MIN_HEIGHT = 1;
    private static final int MIN_WIDTH = 2;

    private final int height;
    private final int width;
    private final LineCreationStrategy strategy;

    public LineFactory(int height, int width) {
        this(height, width, new LineRandomStrategy());
    }

    LineFactory(int height, int width, LineCreationStrategy strategy) {
        validateInput(height, width);

        this.height = height;
        this.width = width;
        this.strategy = strategy;
    }

    private void validateInput(int height, int width) {
        if (height < MIN_HEIGHT || width < MIN_WIDTH) {
            throw new LadderInvalidException();
        }
    }

    public Ladder createLadder() {
        return new Ladder(IntStream.range(0, height)
            .mapToObj(i -> createLine())
            .collect(Collectors.toList()));
    }

    private Line createLine() {
        return new Line(strategy.hasHorizontalLine(width));
    }
}
