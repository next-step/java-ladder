package nextstep.ladder.domain.player;

import java.util.Objects;

public class Player {
    private final Name name;

    public Player(Name name) {
        this.name = name;
    }

    public String name() {
        return name.value();
    }

    public static Player of(String name) {
        return new Player(new Name(name));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return name.equals(player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
