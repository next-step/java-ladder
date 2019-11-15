package ladder.domain.player;

import java.util.Collections;
import java.util.List;

public class Players {
    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public int getMaxLength() {
        return this.players.stream()
                .map(Player::getName)
                .map(String::length)
                .max(Integer::compareTo)
                .get();
    }

    public int size() {
        return players.size();
    }
}
