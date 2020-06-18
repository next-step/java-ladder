package ladder.domain;

import java.util.Optional;

public class Player {

    private final Name name;

    private Player(Name name) {
        this.name = Optional.ofNullable(name)
                .orElseThrow(IllegalArgumentException::new);
    }

    public static Player create(Name name) {
        return new Player(name);
    }

    public Name getName() {
        return this.name;
    }
}
