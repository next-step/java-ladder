package ladder.domain;

import ladder.exception.InvalidNameException;

import java.util.Objects;

public class Player {
    private String name;

    public Player(final String name) {
        validNameLength(name);
        this.name = name;
    }

    private void validNameLength(final String name) {
        if (Objects.isNull(name) || name.trim().isEmpty()) {
            throw new InvalidNameException(name);
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
