package nextstep.ladder.domain.line;

import java.util.ArrayList;
import java.util.List;

public class LineList {
    private final List<Line> lines;

    public LineList(List<Line> lines) {
        this.lines = lines;
    }

    public Line lastLine() {
        return lines.get(lines.size() - 1);
    }

    public int size() {
        return lines.size();
    }

    public void add(Line line) {
        lines.add(line);
    }

    public List<Line> getLines() {
        return lines;
    }
}
