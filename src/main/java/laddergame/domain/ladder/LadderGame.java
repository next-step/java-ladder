package laddergame.domain.ladder;

import java.util.List;
import laddergame.domain.line.Line;
import laddergame.domain.person.Participants;

public class LadderGame {

    private final Ladder ladder;
    private final Participants participants;

    private LadderGame(final Ladder ladder, final Participants participants) {
        this.ladder = ladder;
        this.participants = participants;
    }

    public static LadderGame create(Ladder ladder, Participants participants) {
        return new LadderGame(ladder, participants);
    }

    public List<String> getNames() {
        return participants.getNames();
    }

    public List<Line> getLinePerDepth() {
        return ladder.getLines();
    }
}