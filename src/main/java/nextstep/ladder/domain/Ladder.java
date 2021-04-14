package nextstep.ladder.domain;

import java.util.List;

public class Ladder {
    private final Lines lines;

    public Ladder(Lines lines) {
        this.lines = lines;
    }

    public int height() {
        return lines.size();
    }

    public List<List<Boolean>> linesConnection() {
        return lines.linesConnection();
    }
}
