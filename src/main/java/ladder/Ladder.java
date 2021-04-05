package ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> line;

    public Ladder(int height, int numberOfPlayer, Linker linker) {
        line = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            line.add(new Line(numberOfPlayer, linker));
        }
    }

    public List<Line> line() {
        return line;
    }
}
