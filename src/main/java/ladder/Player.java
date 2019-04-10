package ladder;

import java.util.Objects;

public class Player {

    private PlayerName playerName;

    public Player(PlayerName playerName) {
        this.playerName = playerName;
    }

    public String getName() {
        return playerName.getName();
    }

    @Override
    public String toString() {
        return "     " + playerName.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(playerName, player.playerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName);
    }
}
