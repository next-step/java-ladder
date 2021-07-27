package nextstep.ladder.domain.player;

import java.util.Objects;

public class Player {
    private final String name;

    private Player(String name) {
        validate(name);

        this.name = name;
    }

    private void validate(String name) {
        if (Objects.isNull(name) || name.isEmpty()) {
            throw new IllegalArgumentException("Name can't be null or empty");
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException("Name should less than or equal to 5");
        }
    }

    public static Player init(String name) {
        return new Player(name);
    }
}
