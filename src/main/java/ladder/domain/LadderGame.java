package ladder.domain;

public class LadderGame {
    private final Participants participants;
    private final Ladder ladder;

    public LadderGame(Participants participants, Ladder ladder) {
        validateLadder(participants, ladder);
        this.participants = participants;
        this.ladder = ladder;
    }

    private void validateLadder(Participants participants, Ladder ladder) {
        ladder.validateWidth(participants.countParticipantPerson());
    }

    public Participants fetchParticipants() {
        return participants;
    }

    public Ladder fetchLadder() {
        return ladder;
    }
}

