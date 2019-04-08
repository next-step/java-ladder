package ladder;

public class Player {

    private PlayerName playerName;

    public Player(PlayerName playerName) {
        this.playerName = playerName;
    }

    public String getName() {
        return playerName.getName();
    }

    @Override
    public String toString() {
        return "     " + playerName.getName();
    }

}
