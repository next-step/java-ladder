package domain;

import java.util.Objects;

public class Player {
    private final Name name;
    private final Position position;

    public static Player of(String name, Integer position) {
        return new Player(name, position);
    }

    public static Player of(Name name, Position position) {
        return new Player(name, position);
    }

    private Player(String name, Integer position) {
        this(Name.from(name), Position.valueOf(position));
    }

    private Player(Name name, Position position) {
        this.name = name;
        this.position = position;
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
        return name.toString();
    }
}
