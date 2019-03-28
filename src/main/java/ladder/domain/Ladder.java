package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<Line> lines;

    public Ladder(int height, int lineCount) {
        lines = new ArrayList<>();
        for (int i = 0; i < lineCount; i++) {
            Line line = new Line(height);
            line.createRow();
            lines.add(line);
        }
    }

    public void checkLadder() {
        for (int i = 0; i < lines.size() - 1; i++) {
            lines.get(i).checkLine(lines.get(i + 1));
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
