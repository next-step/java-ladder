package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();

    public Ladder(int width, int height) {
        for (int i = 0; i < height; i++) {
            lines.add(Line.of(width));
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
