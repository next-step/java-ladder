package nextstep.ladder.domain;

import java.util.Objects;

public class Player {
    private final Name name;

    private Player(final Name name) {
        this.name = name;
    }

    public static Player of(final String name) {
        return new Player(Name.of(name));
    }

    public static Player of(final Name name) {
        if (name == null) {
            throw new IllegalArgumentException("invalid name: cannot be null");
        }

        return new Player(name);
    }

    public Name name() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name=" + name +
                '}';
    }
}
