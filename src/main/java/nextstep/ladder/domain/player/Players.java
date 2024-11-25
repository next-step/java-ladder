package nextstep.ladder.domain.player;

import java.util.List;

public class Players {
    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public int playerCount() {
        return players.size();
    }
}
