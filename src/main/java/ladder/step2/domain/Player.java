package ladder.step2.domain;

import java.util.Objects;

public class Player {
    private final String playerName;
    
    public Player(String playerName) {
        this.playerName = playerName;
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
