package nextstep.ladder.domain;

import java.util.Objects;

public class Player {
    private final Name name;

    private Player(Name name) {
        this.name = name;
    }

    public static Player from(String name) {
        return new Player(Name.from(name));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
