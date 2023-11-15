package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;

public class Ladder {

    private List<Name> names;
    private List<Line> lines;

    public Ladder(List<Name> names,
                  List<Line> lines) {
        this.names = names;
        this.lines = lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(names, ladder.names) && Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names, lines);
    }
}
