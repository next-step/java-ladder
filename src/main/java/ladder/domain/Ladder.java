package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int height, int length, LineGenerator lineGenerator) {
        List<Line> lines = new ArrayList<>();
        for (int row = 0; row < height; row++) {
            lines.add(lineGenerator.create(length));
        }
        this.lines = Collections.unmodifiableList(lines);
    }

    public List<Line> getLines() {
        return lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder1 = (Ladder) o;
        return Objects.equals(lines, ladder1.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
