package ladder.domain;

import ladder.strategy.LineStrategy;
import ladder.strategy.RandomLineStrategy;

import java.util.ArrayList;
import java.util.Collections;
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
        return Collections.unmodifiableList(lines);
    }

    private List<Boolean> generateLines(int width) {
        final List<Boolean> newLines = new ArrayList<>();
        newLines.add(generateLine());
        for (int i = 1; i < width; i++) {
            newLines.add(generateLine(newLines.get(i - 1)));
        }

        return newLines;
    }

    private Boolean generateLine() {
        return lineStrategy.isConnectable();
    }

    private Boolean generateLine(boolean preValue) {
        if (preValue) {
            return false;
        }
        return lineStrategy.isConnectable();
    }

    public int size() {
        return lines.size();
    }
}
