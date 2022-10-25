package ladder.domain.ladder.ladderline;

import ladder.domain.ladder.Ladder;

import java.util.List;
import java.util.Objects;

public class LadderLine {

    private final List<Ladder> ladders;

    public LadderLine(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderLine that = (LadderLine) o;
        return Objects.equals(ladders, that.ladders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladders);
    }
}
