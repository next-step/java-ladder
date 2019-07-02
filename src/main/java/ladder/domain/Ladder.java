package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Ladder {
    private List<Line> ladder;

    public Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public int height() {
        return ladder.size();
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder);
    }
}
