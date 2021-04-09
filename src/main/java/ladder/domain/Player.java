package ladder.domain;

public class Player {
    private final PlayerName player;

    public Player(String name) {
        player = new PlayerName(name);
    }

    public PlayerName getNames() {
        return player;
    }
}
