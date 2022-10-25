package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LadderLine {

    private final List<Ladder> ladderList;

    public LadderLine() {
        this.ladderList = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderLine that = (LadderLine) o;
        return Objects.equals(ladderList, that.ladderList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderList);
    }
}
