package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<Line> lines;

    private int height;

    public Ladder(int height, int lineCount) {
        this.height = height;
        lines = new ArrayList<>();
        for (int i = 0; i < lineCount; i++) {
            Line line = new Line(height);
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

    public int getHeight() {
        return height;
    }
}
