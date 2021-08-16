package ladder.model;

public class Player {
    private PlayerName name;

    Player(String name) {
        this.name = new PlayerName(name);
    }

    String getName() {
        return name.getName();
    }
}
