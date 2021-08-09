package ladder.domain.player;

import ladder.domain.Name;

import java.util.Objects;

public class Player {
    private final Name name;

    public Player(Name name) {
        this.name = name;
    }

    public boolean checkName(Name name) {
        return this.name.equals(name);
    }

    @Override
    public String toString() {
        return name.toString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
