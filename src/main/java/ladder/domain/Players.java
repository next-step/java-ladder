package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private List<Player> players;

    public Players(String... players) {
        this.players = Arrays.stream(players)
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
