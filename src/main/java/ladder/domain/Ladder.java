package ladder.domain;

import java.util.Objects;

public class Ladder {
    private final LadderRows ladderRows;

    public Ladder(final LadderRows ladderRows) {
        this.ladderRows = ladderRows;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(ladderRows, ladder.ladderRows);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderRows);
    }
}
