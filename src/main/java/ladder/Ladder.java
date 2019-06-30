package ladder;

import java.util.List;
import java.util.Objects;

public class Ladder {
    private List<Line> ladder;

    public Ladder(List<Line> lines) {
        this.ladder = lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder1 = (Ladder) o;
        return Objects.equals(ladder, ladder1.ladder);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ladder);
    }
}
