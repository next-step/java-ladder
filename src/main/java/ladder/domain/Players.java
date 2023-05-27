package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Players {
    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = players;
    }

    public static Players create(String[] names) {
        return new Players(Stream.of(names)
                .map(Player::new)
                .collect(Collectors.toList()));
    }

    public List<String> getNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }


}
