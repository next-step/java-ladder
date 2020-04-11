package ladder.model.player;

public class Player {
    private PlayerName name;

    public Player(String name) {
        this.name = new PlayerName(name);
    }

    public PlayerName getName() {
        return name;
    }

    public boolean hasEqualName(String name) {
        return name.equals(this.name.getName());
    }
}