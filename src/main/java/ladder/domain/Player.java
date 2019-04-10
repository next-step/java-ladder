package ladder.domain;

public class Player {
    private static final int MAXIMUM_PLAYER_NAME = 5;

    private final String name;

    Player(final String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validate(final String name) {
        if (name.length() > MAXIMUM_PLAYER_NAME) {
            throw new IllegalArgumentException();
        }
    }
}
