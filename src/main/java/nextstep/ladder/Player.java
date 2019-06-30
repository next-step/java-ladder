package nextstep.ladder;

import java.util.Objects;

public class Player {
    private String name;

    Player(String name) {
        this.name = name;
    }

    public String getName() {
        return String.format("%6s", name);
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
