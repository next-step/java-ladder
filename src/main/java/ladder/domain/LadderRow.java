package ladder.domain;

import ladder.strategy.LineStrategy;
import ladder.strategy.RandomLineStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        List<Boolean> newLines = new ArrayList();
        newLines.add(generateLine());
        for (int i = 1; i < width; i++) {
            newLines.add(generateLine(newLines.get(i-1)));
        }
        return newLines;
    }

    private Boolean generateLine() {
        return lineStrategy.isConnectable();
    }

    private Boolean generateLine(boolean prev) {
        if (prev == true) {
            return false;
        }
        return lineStrategy.isConnectable();
    }

    public int size() {
        return lines.size();
    }

    public boolean isEqualTo(List<Boolean> inLines) {
        return lines.equals(inLines);
    }
}
