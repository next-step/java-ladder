package ladder.domain;

import java.util.List;

public class Players {
    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return players.stream()
                .map(player -> " " + player.toString())
                .reduce("", String::concat);
    }
}
