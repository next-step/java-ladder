package ladder.domain;

import ladder.exception.InvalidPlayerNameException;

public class PlayerName {

    public static final int NAME_WIDTH = 5;

    private final String name;

    private PlayerName(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        String trimmed = name.trim();
        if (trimmed.isEmpty() || trimmed.length() > NAME_WIDTH) {
            throw new InvalidPlayerNameException();
        }
    }

    public static PlayerName of(String name) {
        return new PlayerName(name);
    }

    public String getName() {
        return name;
    }
}
