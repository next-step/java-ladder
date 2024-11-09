package ladder.domain;

import java.util.Objects;

public class Player {
    private final Name name;

    public Player(String playerName) {
        this.name = new Name(playerName);
    }

    public Player(Name name) {
        this.name = name;
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
}
