package ladder.model;

public class Player {

    private final Name name;

    public Player(Name name) {
        this.name = name;
    }

    public String name() {
        return name.get();
    }
}
