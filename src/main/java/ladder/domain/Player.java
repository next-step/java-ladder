package ladder.domain;

public class Player {
    private final String name;

    public Player(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        checkNullOrEmpty(name);
        checkNameLength(name);
    }

    private void checkNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("Player name cannot be longer than 5 characters");
        }
    }

    private void checkNullOrEmpty(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Player name cannot be null or empty");
        }
    }

    public String name() {
        return name;
    }
}
