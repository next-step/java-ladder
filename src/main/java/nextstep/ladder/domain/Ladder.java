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

    public int pathFind(int participantPosition) {
        for (Line line : ladder) {
            participantPosition = line.moving(participantPosition);
        }
        return participantPosition;
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder);
    }
}
