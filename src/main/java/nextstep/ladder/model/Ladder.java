package nextstep.ladder.model;

import java.util.Collections;
import java.util.List;

public class Ladder {
    private List<Line> lines;
    private int height;

    public Ladder(List<Line> lines, int height) {
        this.lines = lines;
        this.height = height;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int getHeight() {
        return height;
    }
}
