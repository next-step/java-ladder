package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderFactory {
    List<Line> ladder;

    private LadderFactory(Participants participants, int level) {
        this.ladder = new ArrayList<>();
        for (int i = 0; i < level; i++) {
            ladder.add(new Line(participants.size() - 1));
        }
    }
    public static LadderFactory make(Participants participants, int level) {
        return new LadderFactory(participants, level);
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder);
    }
}
