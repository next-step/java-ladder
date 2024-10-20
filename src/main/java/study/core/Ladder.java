package study.core;

import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
