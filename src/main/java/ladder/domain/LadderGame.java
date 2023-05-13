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

    public Ladder fetchLadder() {
        return ladder;
    }

    public int calculateMaxNameLength() {
        return participants.fetchNames()
                .stream()
                .mapToInt(UserName::calculateNameLength)
                .max()
                .orElse(0); //  + NAME_PADDING;
    }

    public String formatCenterAlignedParticipantNames(int maxOutputNameLength) {
        return participants.centerAlignedParticipantNames(maxOutputNameLength);
    }
}

