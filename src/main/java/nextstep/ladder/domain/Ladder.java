package nextstep.ladder.domain;

import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(LadderGenerator ladderGenerator) {
        this.lines = ladderGenerator.generate();
    }

    public List<Line> getLines() {
        return lines;
    }
}
