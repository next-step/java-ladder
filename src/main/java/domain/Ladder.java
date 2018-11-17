package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public Ladder(int ladderHeight, int size) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            lines.add(new Line(size));
        }
        this.lines = lines;
    }

    public int getFinalPosition(int position) {
        int result = 0;
        for (Line line : lines) {
            result = line.nextPosition(position);
        }
        return result;
    }

    public List<Line> getLines() {
        return lines;
    }

}
