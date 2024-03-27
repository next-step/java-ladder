package nextstep.ladder.domain;

public class LadderGame {

    private final Participants participants;
    private final Ladder ladder;

    public LadderGame(Participants participants, Ladder ladder) {
        this.participants = participants;
        this.ladder = ladder;
    }

    public int getParticipantsSize() {
        return this.participants.getSize();
    }

    public int getLadderHeight() {
        return this.ladder.getHeight();
    }
}
