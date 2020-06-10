package ladder.domain.ladder;

import ladder.domain.strategy.LineStrategy;

public class Point {

    private final boolean hasLine;

    public Point(boolean hasLine) {
        this.hasLine = hasLine;
    }

    public static Point of(boolean hasPreviousLine, LineStrategy lineStrategy) {
        if (hasPreviousLine) {
            return new Point(false);
        }
        return new Point(lineStrategy.hasLine());
    }

    public boolean hasLine() {
        return hasLine;
    }
}
