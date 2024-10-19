package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<Line> lines;
    private int height;

    public Ladder() {
        this(0, new ArrayList<>());
    }

    public Ladder(int height, List<Line> lines) {
        this.height = height;
        this.lines = lines;
    }

    public List<Line> getLines() {
        return lines;
    }

    public int getHeight() {
        return height;
    }
}
