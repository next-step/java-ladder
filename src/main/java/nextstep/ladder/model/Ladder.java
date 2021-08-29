package nextstep.ladder.model;

import java.util.Collections;
import java.util.List;

public class Ladder {
    private List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int getHeight() {
        if (lines.size() == 0) {
            return 0;
        }

        return lines.get(0).getHeight();
    }
}
