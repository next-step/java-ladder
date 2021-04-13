package ladder.controller.dto;

public class LadderGenerationRequest {

    private final String participantNames;
    private final String gameResults;
    private final int ladderHeight;

    public LadderGenerationRequest(String participantNames, String gameResults, int ladderHeight) {
        this.participantNames = participantNames;
        this.gameResults = gameResults;
        this.ladderHeight = ladderHeight;
    }

    public String getParticipantNames() {
        return participantNames;
    }

    public String getGameResults() {
        return gameResults;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }
}
