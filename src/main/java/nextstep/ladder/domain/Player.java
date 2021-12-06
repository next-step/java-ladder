package nextstep.ladder.domain;

import nextstep.ladder.exception.PlayerNameException;

import java.util.Objects;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    private Player(String name) {
        validateName(name);
        this.name = name;
    }

    public static Player from(String name) {
        return new Player(name);
    }

    private static void validateName(String name) {
        if (Objects.isNull(name)) {
            throw new PlayerNameException(null);
        }
        if (name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new PlayerNameException(name);
        }
    }

    public String getName() {
        return name;
    }
}
