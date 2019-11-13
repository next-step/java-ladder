package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private List<Line> lines;

    public Lines() {
        lines = new ArrayList<>();
    }

    public List<Line> apply(Line line) {
        lines.add(line);
        return lines;
    }

    public List<Line> getLadderLines() {
        return lines;
    }
}
