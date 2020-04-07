package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Entry {
    private final List<Player> players;

    private Entry(List<Player> players) {
        if (players.isEmpty()) {
            throw new IllegalArgumentException("참가자는 1명 이상있어야 한다");
        }
        this.players = Collections.unmodifiableList(players);
    }

    public static Entry valueOf(String[] playerNames) {
        List<Player> players = Stream.of(playerNames)
                .map(Player::name)
                .collect(Collectors.toList());
        return new Entry(players);
    }

    public List<String> getPlayerNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }

    public int countOfPlayers() {
        return players.size();
    }
}
