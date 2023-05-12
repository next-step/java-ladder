package laddergame.domain;

import java.util.List;

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