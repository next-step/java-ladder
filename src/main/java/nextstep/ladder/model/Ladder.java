package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<Line> lines;
    private int height;

    public Ladder() {
        this(new ArrayList<>(), 0);
    }

    public Ladder(List<Line> lines, int height) {
        this.lines = lines;
        this.height = height;
    }

    public List<Line> getLines() {
        return lines;
    }

    public int getHeight() {
        return height;
    }
}
