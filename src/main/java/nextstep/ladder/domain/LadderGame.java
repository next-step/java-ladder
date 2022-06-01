package nextstep.ladder.domain;

public class LadderGame {

    private final Participants participants;

    private final LadderInfo ladderInfo;

    public LadderGame(String[] participants, int height) {
        this.participants = new Participants(participants);
        this.ladderInfo = new LadderInfo(height, this.participants.numberOfParticipants());
    }

    public LadderInfo ladderInfo() {
        return ladderInfo;
    }

    public Participants participants() {
        return participants;
    }
}
