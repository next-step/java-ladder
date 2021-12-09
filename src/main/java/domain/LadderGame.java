package domain;

public class LadderGame {
    private final Participants participants;
    private final Ladder ladder;

    public LadderGame(Participants participants, Ladder ladder) {
        this.participants = participants;
        this.ladder = ladder;
    }

    public String result(String name, LadderResult ladderResult) {
        int initialPosition = participants.initialPosition(name);

        return ladderResult.result(ladder.finalPoint(initialPosition));
    }
}
