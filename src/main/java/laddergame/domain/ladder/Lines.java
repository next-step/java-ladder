package laddergame.domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private final List<Line> lines = new ArrayList<>();

    public Lines(int lineNumber, int columnNumber, SelectStrategy selectStrategy) {
        for (int i = 0; i < lineNumber; ++i) {
            lines.add(new Line(columnNumber, selectStrategy));
        }
    }

    public int goDownToEnd(int currentColumn) {
        for (Line line: lines) {
            currentColumn = line.down(currentColumn);
        }
        return currentColumn;
    }

    public List<Line> getLines() {
        return lines;
    }
}
