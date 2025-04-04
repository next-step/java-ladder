package ladder.domain;

import java.util.List;

public class Players {
    private final List<String> players;

    public Players(List<String> players) {
        if (players == null || players.isEmpty()) {
            throw new IllegalArgumentException("Players list cannot be null or empty");
        }

        this.players = players;
    }

    public int count() {
        return players.size();
    }

    public String getNameAtIndex(int i) {
        return players.get(i);
    }
}
