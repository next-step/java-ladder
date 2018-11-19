package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(int height, int countOfPlayer) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0 ; i < height; i++) {
            lines.add(Line.ofAutoLine(countOfPlayer));
        }
        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int move(int index) {
        int position = index;
        for (Line line : lines) {
            position += line.move(position);
        }
        return position;
    }
}
