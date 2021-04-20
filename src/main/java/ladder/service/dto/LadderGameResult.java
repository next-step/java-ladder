package ladder.service.dto;

public class LadderGameResult {

    private final String participantName;
    private final String matchingItem;

    public LadderGameResult(String participantName, String matchingItem) {
        this.participantName = participantName;
        this.matchingItem = matchingItem;
    }

    public String getParticipantName() {
        return participantName;
    }

    public String getMatchingItem() {
        return matchingItem;
    }
}
