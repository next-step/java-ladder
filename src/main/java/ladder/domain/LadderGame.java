package ladder.domain;

public class LadderGame {

    private final Participants participants;
    private final LadderHeight ladderHeight;

    public LadderGame(String names, int height) {
        this.participants = new Participants(names);
        this.ladderHeight = new LadderHeight(height);
    }

    public Ladders getLadders() {
        return new Ladders(participants.size(), ladderHeight);
    }
}
