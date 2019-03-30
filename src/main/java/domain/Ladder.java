package domain;

import java.util.List;
import java.util.function.Consumer;

public class Ladder {
    final private List<Line> lines;

    Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public void paint(Consumer<Line> consumer) {
        lines.forEach(consumer);
    }
}
