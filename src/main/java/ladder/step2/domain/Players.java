package ladder.step2.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;
    
    public Players(List<Player> players) {
        this.players = players;
    }
    
    public int size() {
        return players.size();
    }
    
    @Override
    public String toString() {
        return players.stream()
                .map(Player::toString)
                .collect(Collectors.joining());
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Players players1 = (Players) o;
        return Objects.equals(players, players1.players);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(players);
    }
}
