package ladder.domain;

import java.util.List;

public class Lines {
    private final List<Line> lines;
    private final Results results;

    public Lines(final List<Line> lines, final Results results) {
        this.lines = lines;
        this.results = results;
    }

    public String findResultBy(final int order) {
        int endIndex = getNextLineIndex(order);
        for (Line line : lines) {
            endIndex = line.getEndIndex(endIndex);
        }
        return results.get(lines.get(lines.size() - 1).getOrderByNextLine(endIndex));
    }

    public List<Line> lines() {
        return lines;
    }
    
    private int getNextLineIndex(final int order) {
        return lines.get(0).getNextLineIndexBy(order);
    }
}
