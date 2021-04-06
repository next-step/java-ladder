package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int height, int numberOfPlayer, LinkSelector linkSelector) {
        lines = new ArrayList<>();
        Linker linker = new Linker(linkSelector);

        for (int i = 0; i < height; i++) {
            lines.add(new Line(numberOfPlayer, linker));
        }
    }

    public List<Line> lines() {
        return lines;
    }
}
