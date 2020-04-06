package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private List<Player> players;

    public Players(List<String> players) {
        this.players = players.stream()
                .map(s -> Player.of(s))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayers() {
        return new ArrayList<>(this.players);
    }

    public int getPlayersCount() {
        return this.players.size();
    }
}
