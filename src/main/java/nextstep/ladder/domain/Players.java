package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = players;
    }

    public static Players from(List<String> names) {
        List<Player> players = names.stream()
                .map(Player::from)
                .collect(Collectors.toList());

        return new Players(players);
    }

    public int numOfPlayers() {
        return players.size();
    }

    public List<String> namesOfPlayers() {
        return players.stream()
                .map(Player::toString)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return players.stream()
                .map(Player::toString)
                .collect(Collectors.joining());
    }
}
