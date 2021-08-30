package nextstep.ladder.domain;

import java.util.Objects;

public class Player {
    private final String name;
    private final int number;

    public Player(final String name, final int number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return number == player.number &&
                Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number);
    }
}
