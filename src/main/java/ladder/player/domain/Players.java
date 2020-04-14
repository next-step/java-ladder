package ladder.player;

import ladder.ladder.domain.NotEnoughCountOfPersonException;

import java.util.List;

public class Players {
    private static final int MIN_PLAYERS = 2;

    private final List<Player> players;

    public Players(List<Player> players) {
        validate(players);
        this.players = players;
    }

    private void validate(List<Player> players) {
        if (players.size() < MIN_PLAYERS) {
            throw new NotEnoughCountOfPersonException();
        }
    }
}
