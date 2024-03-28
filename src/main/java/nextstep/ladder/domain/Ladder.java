package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    
    private final List<Line> lines;

    public Ladder(final int numberOfPeople, final int height) {
        lines = new ArrayList<>();
        while (lines.size() < height) {
            lines.add(new Line(numberOfPeople));
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
