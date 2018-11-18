package domain.ladder;

import java.util.List;

public class Players {
    private List<Player> players;


    public Players(List<Player> players) {
        this.players = players;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
