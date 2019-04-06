package ladder;

public class Player {

    private PlayerName playerName;

    public Player(PlayerName playerName) {
        this.playerName =  playerName;
    }

    String getName() {
        return playerName.getName();
    }

}
