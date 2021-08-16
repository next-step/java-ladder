package ladder.model;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Players {
    private final List<Player> players;

    private Players(List<String> playerNames) {
        this.players = playerNames.stream()
                .map(Player::new)
                .collect(toList());
    }

    static Players of(List<String> playerNames) {
        return new Players(playerNames);
    }

    List<String> getNames() {
        return players.stream()
                .map(Player::getName)
                .collect(toList());
    }
}
