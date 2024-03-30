package ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<Line> lines = new ArrayList<>();

    public Ladder(int heightOfLadder, int nameNum) {
        for (int i = 0; i < heightOfLadder; i++) {
            this.lines.add(new Line(nameNum));
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
