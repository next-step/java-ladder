package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players.stream()
                .distinct()
                .collect(Collectors.toUnmodifiableList());
    }

    public int countOfPlayer() {
        return players.size();
    }

    public List<String> getNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toUnmodifiableList());
    }
}
