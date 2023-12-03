package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    List<Line> ladder;

    private Ladder(Participants participants, int level) {
        this.ladder = new ArrayList<>();
        for (int i = 0; i < level; i++) {
            ladder.add(new Line(participants.size() - 1));
        }
    }
    public static Ladder make(Participants participants, int level) {
        return new Ladder(participants, level);
    }

    public int pathFind(int index) {
        for (Line line : ladder) {
            index = line.following(index);
        }
        return index;
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder);
    }
}
