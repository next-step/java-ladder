package ladder.domain;

public class Player {

    private final PlayerName playerName;

    private Player(PlayerName playerName) {
        this.playerName = playerName;
    }

    public static Player of(String name){
        return new Player(PlayerName.of(name));
    }

    public String playerName() {
        return playerName.name();
    }
}
