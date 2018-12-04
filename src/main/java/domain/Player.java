package domain;

import java.util.Objects;

import static java.util.Optional.ofNullable;

public class Player {

    private final String name;

    public Player(final String name) {
        validation(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean eqName(final String name) {
        return this.name.equals(name);
    }

    private void validation(final String name) {
        ofNullable(name).filter(n -> n.length() <= 5 && n.length() > 0)
                .orElseThrow(IllegalArgumentException::new);
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

    @Override
    public String toString() {
        return name;
    }

}
