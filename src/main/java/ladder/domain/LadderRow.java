package ladder.domain;

import ladder.strategy.LineStrategy;
import ladder.strategy.RandomLineStrategy;

import java.util.ArrayList;
import java.util.List;

public class LadderRow {
    private static final LineStrategy DEFAULT_STRATEGY = new RandomLineStrategy();

    private List<Boolean> lines;
    private LineStrategy lineStrategy;

    public LadderRow(int width) {
        lineStrategy = DEFAULT_STRATEGY;
        lines = generateLines(width);
    }

    public LadderRow(int width, LineStrategy lineStrategy) {
        this.lineStrategy = lineStrategy;
        lines = generateLines(width);
    }

    public List<Boolean> getLines() {
        return lines;
    }

    private List<Boolean> generateLines(int width) {
        final List<Boolean> newLines = new ArrayList();
        newLines.add(generateLine());
        for (int i = 1; i < width; i++) {
            newLines.add(generateLine(newLines.get(i - 1)));
        }
        return newLines;
    }

    private Boolean generateLine() {
        return lineStrategy.isConnectable();
    }

    private Boolean generateLine(boolean prev) {
        if (prev) {
            return false;
        }
        return lineStrategy.isConnectable();
    }

    public Direction determineDirection(int x) {
        if (!isOnRightEdge(x) && lines.get(x)) {
            return Direction.RIGHT;
        }
        if (!isOnLeftEdge(x) && lines.get(x - 1)) {
            return Direction.LEFT;
        }
        return Direction.DOWN;
    }

    private boolean isOnLeftEdge(int x) {
        return x == 0;
    }

    private boolean isOnRightEdge(int x) {
        return x == lines.size();
    }

    public int size() {
        return lines.size();
    }

    public boolean isEqualTo(List<Boolean> inLines) {
        return lines.equals(inLines);
    }
}
