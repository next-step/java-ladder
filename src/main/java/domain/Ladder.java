package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    private Ladder(int ladderHeight, int size) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            lines.add(Line.ofCount(size));
        }
        this.lines = lines;
    }

    public static Ladder ofCount(int ladderHeight, int size) {
        return new Ladder(ladderHeight, size);
    }

    public int getFinalPosition(int position) {
        int result = 0;
        for (Line line : lines) {
            result = line.nextPosition(position);
        }
        return result;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

}
