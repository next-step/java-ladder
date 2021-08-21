package ladder.domain;

public class Player {
    private final Name name;

    public Player(final String name) {
        this(new Name(name));
    }

    public Player(final Name name) {
        this.name = name;
    }

    public String getName() {
        return name.getValue();
    }
}
