package laddergame.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    public Players(List<String> names) {
        this.players = names.stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public Players(String... names) {
        this(Arrays.asList(names));
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public int count() {
        return this.players.size();
    }
}
