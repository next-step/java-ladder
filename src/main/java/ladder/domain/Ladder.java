package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(List<Line> lines) {
        return new Ladder(lines);
    }
    
    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int move(int index) {
        int position = index;
        for (Line line : lines) {
            position += line.nextDirection(position);
        }
        return position;
    }

}
