package ladder.model;

import java.util.Collections;
import java.util.List;

public class Players {
    private List<Player> players;

    public Players(List<Player> players) {
        this.players = Collections.unmodifiableList(players);
    }

    public static Players create(List<Player> players) {
        return null;
    }

    public int getPlayerCount(){
        return players.size();
    }
}
