package ladder.controller.dto;

public class LadderGameResponse {

    private final String gameResult;

    public LadderGameResponse(String gameResult) {
        this.gameResult = gameResult;
    }

    public String getGameResult() {
        return gameResult;
    }
}
