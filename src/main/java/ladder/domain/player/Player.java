package ladder.domain.player;

import ladder.domain.name.Name;
import ladder.exception.ErrorMessage;

import java.util.Objects;

public class Player {

    private final Name name;

    private Player(final Name name) {
        verifyName(name);
        this.name = name;
    }

    public static Player of(final String name) {
        return new Player(Name.of(name));
    }

    private void verifyName(final Name name) {
        if (Objects.isNull(name)) {
            throw new IllegalArgumentException(ErrorMessage.NULL_VALUE);
        }
    }

    public String getName() {
        return name.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return name.equals(player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
