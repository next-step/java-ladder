package ladder.domain;

import java.util.Objects;
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

    @Override
    public String toString() {
        return "Player{" +
                "name=" + name +
                '}';
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
}
