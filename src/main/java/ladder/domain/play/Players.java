package ladder.domain.play;

import java.util.List;

public class Players {
    private final Items players;

    private Players(List<String> players) {
        this.players = Items.of(players);
    }

    public static Players of(List<String> players) {
        return new Players(players);
    }

    public int getCountOf() {
        return players.getCountOfItems();
    }

    @Override
    public String toString() {
        return players.toString();
    }
}
