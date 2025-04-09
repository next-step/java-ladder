package ladder.domain;

public class Player {
    private final String name;
    private final Position position;

    public Player(String name, Position position) {
        validateName(name);
        this.name = name;
        this.position = position;
    }

    public String name() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    private void validateName(String name) {
        checkNullOrEmpty(name);
        checkNameLength(name);
    }

    private void checkNameLength(String name) {
        if (name.length() > LadderConstants.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("Player name cannot be longer than 5 characters");
        }
    }

    private void checkNullOrEmpty(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Player name cannot be null or empty");
        }
    }
}
