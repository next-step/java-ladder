package ladder.model;

import static ladder.Messages.WARNING_NOT_ALLOWED_NAME_LENGTH;

public class Player {
    private String name;

    public Player(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(WARNING_NOT_ALLOWED_NAME_LENGTH);
        }
    }

    public String getName() {
        return name;
    }
}
