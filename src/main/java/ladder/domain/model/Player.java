package ladder.domain.model;

public class Player {
    private PlayerName playerName;
    private int result = 0;

    public Player(PlayerName playerName, int result) {
        this.playerName = playerName;
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    public void changeResult(int index) {
        result = index;
    }
}
