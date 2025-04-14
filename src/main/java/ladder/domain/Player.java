package ladder.domain;

import java.util.List;

public class Player {
    private final String name;
    private final Position position;
    private final String result;

    public Player(String name, Position position) {
        validateName(name);
        this.name = name;
        this.position = position;
        this.result = LadderConstants.NO_RESULT;
    }

    public Player(String name, Position position, String result) {
        validateName(name);
        this.name = name;
        this.position = position;
        this.result = result;
    }

    public String name() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public String result() {
        return result;
    }

    public Player checkResult(List<String> results) {
        String result = results.get(position.value());
        return new Player(name, position, result);
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

    @Override
    public int hashCode() {
        int nameHashCode = name.hashCode();
        int combinedHash = nameHashCode + 31 * position.hashCode();
        return combinedHash + 31 * result.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Player)) {
            return false;
        }

        Player other = (Player) obj;

        return other.name.equals(name) && other.position.equals(position)
                && other.result.equals(result);
    }
}
