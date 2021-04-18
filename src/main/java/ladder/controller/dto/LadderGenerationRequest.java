package ladder.controller.dto;

public class LadderGenerationRequest {

    private final String participantNames;
    private final String matchingItems;
    private final int ladderHeight;

    public LadderGenerationRequest(String participantNames, String matchingItems, int ladderHeight) {
        this.participantNames = participantNames;
        this.ladderHeight = ladderHeight;
        this.matchingItems = matchingItems;
    }

    public String getParticipantNames() {
        return participantNames;
    }

    public String getMatchingItems() {
        return matchingItems;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }
}
