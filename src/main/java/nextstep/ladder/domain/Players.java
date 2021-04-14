package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static nextstep.ladder.utils.StringUtil.splitWithComma;

public class Players {
    private final List<Player> players;

    public Players(String names) {
        this(convertToPlayers(splitWithComma(names)));
    }

    private static List<Player> convertToPlayers(List<String> names) {
        return names.stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }

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

    public List<Player> allPlayers() {
        return players;
    }

    public List<String> names() {
        return players.stream()
                .map(Player::name)
                .collect(Collectors.toList());
    }

    public CountOfPlayer countOfPlayer() {
        return new CountOfPlayer(players.size());
    }
}