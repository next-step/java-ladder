package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;

public class Lines {
    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
