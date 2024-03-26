package domain;

import java.util.List;

public class Players {
    private final List<Player> players;

    public static Players from(List<Player> players) {
        return new Players(players);
    }

    private Players(List<Player> players) {
        this.players = players;
    }

    public int size() {
        return players.size();
    }
}
