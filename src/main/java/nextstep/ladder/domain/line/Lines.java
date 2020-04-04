package nextstep.ladder.domain.line;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private List<Line> lines = new ArrayList<>();

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

    public int lineHeight() {
        //TODO get 0 check
        return lines.get(0).getLineHeight();
    }
}
