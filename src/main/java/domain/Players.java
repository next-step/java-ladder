package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Players {
    public static final String PLAYER_NAME_SPACE = "   ";
    private final List<Player> players;

    public static Players from(List<Player> players) {
        return new Players(players);
    }

    private Players(List<Player> players) {
        this.players = players;
    }

    public int size() {
        return players.size();
    }

    @Override
    public String toString() {
        return players.stream()
                .map(Player::toString)
                .collect(Collectors.joining(PLAYER_NAME_SPACE));
    }
}
