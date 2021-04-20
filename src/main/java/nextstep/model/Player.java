package nextstep.model;

import java.util.List;
import java.util.Objects;

public class Player {
    private final String player;

    public Player(String name) {
        this.player = name;
    }

    public String player() {
        return this.player;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player1 = (Player) o;
        return Objects.equals(player, player1.player);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player);
    }
}
