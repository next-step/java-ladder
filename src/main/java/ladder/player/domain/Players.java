package ladder.player.domain;

import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Players {
    private static final int MIN_PLAYERS = 2;

    private final List<Player> players;

    private Players(List<Player> players) {
        validate(players);
        this.players = players;
    }

    public static Players of(List<String> playerNames) {
        return playerNames.stream()
                .map(Player::of)
                .collect(collectingAndThen(toList(), Players::new));
    }

    public List<String> getPlayerNames() {
        return players.stream()
                .map(Player::getName)
                .collect(toList());
    }

    public int size() {
        return players.size();
    }

    private void validate(List<Player> players) {
        if (players.size() < MIN_PLAYERS) {
            throw new NotEnoughCountOfPersonException();
        }
    }
}
