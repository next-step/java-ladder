package ladder.domain;

import java.util.Objects;

public class Player {
    private final String player;

    public Player(String player) {
        this.player = player;
    }

    public String whiteSpacePlayer() {
        return "";
    }

    @Override
    public String toString() {
        return player;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player1 = (Player) o;
        return Objects.equals(player, player1.player);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player);
    }
}
