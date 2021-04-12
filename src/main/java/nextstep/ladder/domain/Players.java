package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    public Players(String... names) {
        this(convertToPlayers(names));
    }

    private static List<Player> convertToPlayers(String[] names) {
        return Arrays.stream(names)
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public Players(List<Player> players) {
        this.players = players;
    }

    public static Players from(List<String> names) {
        return new Players(names.stream()
                .map(Player::new)
                .collect(Collectors.toList()));
    }

    public List<Player> allPlayers() {
        return players;
    }

    public String names() {
        return players.stream()
                .map(Player::name)
                .collect(Collectors.joining(" "));
    }

    public CountOfPlayer countOfPlayer() {
        return new CountOfPlayer(players.size());
    }
}