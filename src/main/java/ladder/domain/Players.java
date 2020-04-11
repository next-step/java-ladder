package ladder.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Players {
    private final List<Player> players;

    private Players(List<Player> players) {
        if (players.isEmpty()) {
            throw new IllegalArgumentException("참가자는 1명 이상있어야 한다");
        }
        this.players = Collections.unmodifiableList(players);
    }

    public static Players valueOf(String[] playerNames) {
        List<Player> players = Stream.of(playerNames)
                .map(Player::name)
                .collect(Collectors.toList());
        return new Players(players);
    }

    public List<String> getPlayerNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }

    public int countOfPlayers() {
        return players.size();
    }

    public int indexOf(Player player) {
        return players.indexOf(player);
    }

    public Player get(int i) {
        return players.get(i);
    }
}
