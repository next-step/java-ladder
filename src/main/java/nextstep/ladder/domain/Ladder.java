package nextstep.ladder.domain;

import java.util.List;

public class Ladder {

    private final List<Line> lines;

    public Ladder(List<Line> lines) throws Exception {
        this.lines = lines;
    }

    public List<Line> lines() {
        return this.lines;
    }
}
