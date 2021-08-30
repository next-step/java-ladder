package nextstep.ladders;

import java.util.Objects;

public class Ladder {

    private final Lines lines;
    private final LadderDetail ladderDetail;

    public Ladder(final Lines lines, final LadderDetail ladderDetail) {
        this.lines = lines;
        this.ladderDetail = ladderDetail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines) && Objects.equals(ladderDetail, ladder.ladderDetail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines, ladderDetail);
    }
}
