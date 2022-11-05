package nextstep.ladder.model;

import java.util.List;

public class Players {
    private List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return players + "  ";
    }
}
