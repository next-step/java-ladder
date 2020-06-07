package nextstep.ladder.domain;

import java.util.Objects;

public class Player {
    private final static int MAX_NAME_LENGTH = 5;

    private final String name;

    public Player(String name) {
        this.validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (Objects.isNull(name) || name.trim().isEmpty()) {
            throw new IllegalArgumentException("name is required");
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("name length must be less than %d", MAX_NAME_LENGTH));
        }
    }

    public String getName() {
        return this.name;
    }
}
