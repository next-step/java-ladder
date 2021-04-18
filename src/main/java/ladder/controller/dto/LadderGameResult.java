package ladder.controller.dto;

public class LadderGameResult {

    private final String participantName;
    private final String gameResult;

    public LadderGameResult(String participantName, String gameResult) {
        this.participantName = participantName;
        this.gameResult = gameResult;
    }

    public String getParticipantName() {
        return participantName;
    }

    public String getGameResult() {
        return gameResult;
    }
}
