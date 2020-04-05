package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public List<Player> getPlayers() {
        return new ArrayList<>(this.players);
    }

    public int getPlayersCount() {
        return this.players.size();
    }
}
