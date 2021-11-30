package nextstep.ladder.domain;

import java.util.Objects;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    private Player(String name) {
        this.name = name;
    }

    public static Player from(String name) {
        validateName(name);
        return new Player(name);
    }

    private static void validateName(String name) {
        if (Objects.isNull(name) || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(name);
        }
    }
}
