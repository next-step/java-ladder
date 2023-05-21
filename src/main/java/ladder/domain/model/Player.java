package ladder.domain.model;

public class Player {
    private PlayerName playerName;
    private int result;

    public Player(PlayerName playerName, int result) {
        this.playerName = playerName;
        this.result = result;
    }

    public boolean equalPlayerName(String playerName) {
        return this.playerName
                .getName()
                .trim()
                .equals(playerName);
    }

    public int getResult() {
        return result;
    }

    public void move(int index) {
        result = index;
    }

    public String getPlayerName() {
        return playerName.getName();
    }
}
