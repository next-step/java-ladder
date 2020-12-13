package ladder.domain;

import ladder.dto.LadderGameResult;

public class LadderGame {

    private final Participants participants;
    private final LadderHeight ladderHeight;

    public LadderGame(Participants participants, LadderHeight ladderHeight) {
        this.participants = participants;
        this.ladderHeight = ladderHeight;
    }

    public LadderGameResult getLadderGameResult() {
        return new LadderGameResult(getLadders(), participants.getValue());
    }

    private Ladder getLadders() {
        return new Ladder(participants.size() + participants.size() - 1, ladderHeight);
    }
}
