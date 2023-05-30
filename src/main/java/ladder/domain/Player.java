package ladder.domain;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Player(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isNameEqual(String name) {
        return this.name == name;
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("Input should be within %d characters, but %d characters were provided.", MAX_NAME_LENGTH, name.length()));
        }
    }
}
