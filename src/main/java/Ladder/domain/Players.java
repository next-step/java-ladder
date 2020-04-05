package Ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private static final int MINIMUM_PLAYER_COUNT = 2;

    private final List<Player> players;

    private Players(final List<Player> players) {
        validatePlayerCount(players);
        this.players = players;
    }

    public Players(final String... players) {
        this(Arrays.stream(players)
                .map(Player::new)
                .collect(Collectors.toList()));
    }

    private void validatePlayerCount(final List<Player> players) {
        if (players == null || players.size() < MINIMUM_PLAYER_COUNT) {
            throw new IllegalArgumentException("Player number must be more than 2");
        }
    }

    public int getPlayersNumber() {
        return this.players.size();
    }

    public Player getPlayer(final int index) {
        return players.get(index);
    }

}
