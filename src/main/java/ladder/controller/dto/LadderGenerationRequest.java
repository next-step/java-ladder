package ladder.controller.dto;

public class LadderGenerationRequest {

    private final String participants;
    private final int ladderHeight;

    public LadderGenerationRequest(String participants, int ladderHeight) {
        this.participants = participants;
        this.ladderHeight = ladderHeight;
    }

    public String getParticipants() {
        return participants;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }
}
