package ladder.model.player;

import ladder.model.name.Name;

public class Player {

    private final Name name;

    public Player(Name name) {
        this.name = name;
    }

    public String name() {
        return name.get();
    }
}
