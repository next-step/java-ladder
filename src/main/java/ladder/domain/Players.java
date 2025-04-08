package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    public Players(List<String> players) {
        if (players == null || players.isEmpty()) {
            throw new IllegalArgumentException("Players list cannot be null or empty");
        }

        this.players = players.stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public int count() {
        return players.size();
    }

    public Player getPlayerAtIndex(int i) {
        return players.get(i);
    }
}
