package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(final int playerCount, final Height height) {
        this.lines = createLines(playerCount, height);
    }

    public List<Line> getLines() {
        return lines;
    }

    private List<Line> createLines(final int playerCount, final Height height) {
        List<Line> lines = new ArrayList<>();
        for (int i = Height.MIN_HEIGHT; i <= height.value(); i++) {
            lines.add(new Line(playerCount));
        }
        return Collections.unmodifiableList(lines);
    }
}
