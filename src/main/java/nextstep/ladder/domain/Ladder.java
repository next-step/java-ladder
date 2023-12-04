package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> ladder;

    private Ladder(List<Line> lines) {
        this.ladder = new ArrayList<>(lines);
    }
    public static Ladder make(Participants participants, int level) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < level; i++) {
            lines.add(Line.make(participants.size()));
        }
        return new Ladder(lines);
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
