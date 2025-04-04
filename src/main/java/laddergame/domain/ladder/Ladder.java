package laddergame.domain.ladder;

import java.util.*;

public class Ladder {
    private final List<Line> points = new ArrayList<>();
    private final int columnNumber;

    public Ladder(int lineNumber, int columnNumber, SelectStrategy selectStrategy) {
        this.columnNumber = columnNumber;
        for (int i = 0; i < lineNumber; ++i) {
            points.add(new Line(columnNumber, selectStrategy));
        }
    }

    public List<Line> getPoints() {
        return points;
    }

    public Map<Integer, Integer> makeGameResult() {
        Map<Integer, Integer> result = new LinkedHashMap<>();
        for (int i = 0; i < columnNumber; ++i) {
            int currentColumn = i;
            for (int j = 0; j < points.size(); ++j) {
                currentColumn = points.get(j).down(currentColumn);
            }
            result.put(i, currentColumn);
        }
        return result;
    }
}
