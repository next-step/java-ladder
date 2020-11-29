package nextstep.ladder.domain;

import java.util.Objects;

public class Player {
    private String name;

    public Player(String name) {
        if (name.length() > 5)
            throw new IllegalArgumentException("name must be over 5");

        this.name = name;
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
