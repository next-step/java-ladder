package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public class Ladder {
    private final List<Line> lines;

    private Ladder(final List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(final int height, final int countOfPerson, Supplier<Boolean> supplier) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.of(countOfPerson, supplier));
        }
        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
