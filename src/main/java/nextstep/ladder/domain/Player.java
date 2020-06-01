package nextstep.ladder.domain;

import java.util.Optional;

public class Player {

    private final static int MAX_OF_NAME_LENGTH = 5;
    private final String name;

    private Player(String name) {
        validateName(name);
        this.name = name;
    }

    public static Player of(String name) {
        return new Player(name);
    }

    public String getName() {
        return name;
    }

    private void validateName(String name) {
        int length = Optional.ofNullable(name)
            .map(String::trim)
            .map(String::length)
            .orElse(MAX_OF_NAME_LENGTH + 1);

        if (length > MAX_OF_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
