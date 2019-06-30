package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Ladder {
    List<Line> ladder;

    public Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public int height() {
        return ladder.size();
    }

    public int countOfLine() {
        return ladder.get(0).size();
    }

    public List<Line> isLadderInfo() {
        return Collections.unmodifiableList(ladder);
    }
}
