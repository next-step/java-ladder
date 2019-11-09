package ladder.domain;

import java.util.List;
import java.util.Objects;

public class LadderRows {
    private final List<LadderRow> ladderRows;

    public LadderRows(final List<LadderRow> ladderRows) {
        this.ladderRows = ladderRows;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderRows that = (LadderRows) o;
        return Objects.equals(ladderRows, that.ladderRows);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderRows);
    }
}
