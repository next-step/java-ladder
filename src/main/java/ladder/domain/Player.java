package ladder.domain;

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
    public boolean equals(Object compareValue) {
        if (this == compareValue) return true;
        if (compareValue == null || getClass() != compareValue.getClass()) return false;
        Player player = (Player) compareValue;
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
