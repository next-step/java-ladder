package nextstep.ladder.domain.line;

import java.util.List;

public class LineList {
    private final List<Line> lines;

    public LineList(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return lines;
    }
}
