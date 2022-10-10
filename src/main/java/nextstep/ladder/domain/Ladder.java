package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    public Ladder(final List<Line> lines) {

        this.lines = lines;
    }

    public List<Line> getLines() {

        return Collections.unmodifiableList(this.lines);
    }
}
