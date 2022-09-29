package ladder.step2.domain;

import java.util.Objects;

public class Player {
    private final PlayerName playerName;
    
    public Player(PlayerName playerName) {
        this.playerName = playerName;
    }
    
    @Override
    public String toString() {
        return playerName.toString();
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
