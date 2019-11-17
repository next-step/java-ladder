package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Lines {

    private List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLadderLines() {
        return new ArrayList<>(lines);
    }
}
