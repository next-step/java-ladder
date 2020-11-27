package step2.domain;

import java.util.Collections;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class Players {
    private List<Player> players;

    private Players(List<Player> players) {
        this.players = players;
    }

    public static Players of(List<Player> players) {
        return new Players(players);
    }

    public int getPlayersCount() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return unmodifiableList(players);
    }
}
