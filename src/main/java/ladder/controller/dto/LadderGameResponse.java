package ladder.controller.dto;

public class LadderGameResponse {

    private final String participantName;
    private final String gameResult;

    public LadderGameResponse(String participantName, String gameResult) {
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
