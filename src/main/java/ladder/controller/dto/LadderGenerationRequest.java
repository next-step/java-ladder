package ladder.controller.dto;

public class LadderGenerationRequest {

    private final String participantNames;
    private final int ladderHeight;
    private final String gameResults;

    public LadderGenerationRequest(String participantNames, int ladderHeight, String gameResults) {
        this.participantNames = participantNames;
        this.ladderHeight = ladderHeight;
        this.gameResults = gameResults;
    }

    public String getParticipantNames() {
        return participantNames;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }

    public String getGameResults() {
        return gameResults;
    }
}
