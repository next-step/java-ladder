package Ladder.domain;

public class Player {
    private static final int MAXIMUM_NAME_LENGTH = 5;

    private final String name;

    public Player(final String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(final String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("Name must be shorter than 5, current : " + name.length());
        }
    }

    public String getName() {
        return name;
    }
}
