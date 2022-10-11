package step1.domain;

import java.util.List;
import java.util.Objects;

public class Ladder {

    private final Lines lines;

    public Ladder(Lines lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return lines.getLines();
    }

    public int getHeight() {
        return lines.getHeight();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Ladder)) {
            return false;
        }

        Ladder ladder = (Ladder) o;

        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return lines != null ? lines.hashCode() : 0;
    }
}
