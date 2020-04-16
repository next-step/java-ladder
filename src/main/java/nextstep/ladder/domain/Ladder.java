package nextstep.ladder.domain;

import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<LadderLine> ladder;

    public Ladder(List<LadderLine> ladder) {
        this.ladder = unmodifiableList(new ArrayList<>(ladder));
    }

    public List<LadderLine> getLadder() {
        return ladder;
    }
}
