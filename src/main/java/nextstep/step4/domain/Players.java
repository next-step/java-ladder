package nextstep.step4.domain;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.*;

public class Players {

    private final List<PlayerName> players;

    private Players(List<PlayerName> players) {
        this.players = players;
    }

    public static Players from(List<String> players) {
        return new Players(players.stream()
                .map(PlayerName::from)
                .collect(Collectors.toList()));
    }

    public int getCountOfPlayer() {
        return players.size();
    }

    public List<PlayerName> getPlayers() {
        return unmodifiableList(players);
    }

    public PlayerName findPlayerByColumn(int column) {
        return players.get(column);
    }

}
