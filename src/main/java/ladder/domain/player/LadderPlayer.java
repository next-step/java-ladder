package ladder.domain.player;

public class LadderPlayer {

    private String playerName;

    private LadderPlayer(String playerName) {
        this.playerName = playerName;
    }

    public static LadderPlayer create(String playerName) {
        return new LadderPlayer(playerName);
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
