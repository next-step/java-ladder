package nextstep.ladder;

import java.util.List;

public class Ladder {

    List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return lines;
    }
}
