package ladder.model.player;

import ladder.model.row.Rows;

import java.util.Collections;
import java.util.List;

public class Players {
    private List<Player> players;

    private Players(List<Player> players) {
        this.players = Collections.unmodifiableList(players);
    }

    public static Players create(List<Player> players) {
        return new Players(players);
    }

    public int getPlayerCount() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Integer findFinalLocation(Rows rows, Player player) {
        return null;
    }

    public Integer findFinalLocationByName(Rows rows, String name) {
        return null;
    }
}
