package ladder.controller.dto;

public class LadderGenerationRequest {

    private final String participantNames;
    private final int ladderHeight;

    public LadderGenerationRequest(String participantNames, int ladderHeight) {
        this.participantNames = participantNames;
        this.ladderHeight = ladderHeight;
    }

    public String getParticipantNames() {
        return participantNames;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }
}
