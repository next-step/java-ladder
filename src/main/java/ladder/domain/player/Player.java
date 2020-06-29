package ladder.domain.player;

import java.util.Objects;
import java.util.Optional;

public class Player {

    private static final Player ALL = Player.create(Name.valueOf("all"));

    private final Name name;

    private Player(Name name) {
        this.name = Optional.ofNullable(name)
                .orElseThrow(IllegalArgumentException::new);
    }

    public static Player create(Name name) {
        return new Player(name);
    }

    public static Player all() {
        return ALL;
    }

    public Name getName() {
        return this.name;
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
