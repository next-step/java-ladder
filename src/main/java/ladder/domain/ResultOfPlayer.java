package ladder.domain;

public class ResultOfPlayer {
    private final String playerName;
    private final String result;

    public ResultOfPlayer(String playerName, String result) {
        this.playerName = playerName;
        this.result = result;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getResult() {
        return result;
    }
}
