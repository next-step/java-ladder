package domain;

import static java.util.Optional.ofNullable;

public class Player {

    private final String name;

    public Player(final String name) {
        validation(name);
        this.name = name;
    }

    private void validation(final String name) {
        ofNullable(name).filter(n -> n.length() <= 5 && n.length() > 0)
                .orElseThrow(IllegalArgumentException::new);
    }

}
