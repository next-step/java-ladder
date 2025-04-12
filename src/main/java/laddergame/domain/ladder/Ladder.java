package laddergame.domain.ladder;

import java.util.*;

public class Ladder {
    private final Lines lines;
    private final int columnNumber;

    public Ladder(int lineNumber, int columnNumber, SelectStrategy selectStrategy) {
        this.columnNumber = columnNumber;
        lines = new Lines(lineNumber, columnNumber, selectStrategy);
    }

    public List<Line> getLines() {
        return lines.getLines();
    }

    public Map<Integer, Integer> makeGameResult() {
        Map<Integer, Integer> result = new LinkedHashMap<>();
        for (int currentColumn = 0; currentColumn < columnNumber; ++currentColumn) {
            result.put(currentColumn, lines.goDownToEnd(currentColumn));
        }
        return result;
    }
}
