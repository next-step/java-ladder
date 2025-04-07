package laddergame.domain.ladder;

import java.util.*;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();
    private final int columnNumber;

    public Ladder(int lineNumber, int columnNumber, SelectStrategy selectStrategy) {
        this.columnNumber = columnNumber;
        for (int i = 0; i < lineNumber; ++i) {
            lines.add(new Line(columnNumber, selectStrategy));
        }
    }

    public List<Line> getLines() {
        return lines;
    }

    public Map<Integer, Integer> makeGameResult() {
        Map<Integer, Integer> result = new LinkedHashMap<>();
        for (int i = 0; i < columnNumber; ++i) {
            int currentColumn = i;
            result.put(i, goDownToEnd(currentColumn));
        }
        return result;
    }

    private int goDownToEnd(int currentColumn) {
        for (int j = 0; j < lines.size(); ++j) {
            currentColumn = lines.get(j).down(currentColumn);
        }
        return currentColumn;
    }
}
