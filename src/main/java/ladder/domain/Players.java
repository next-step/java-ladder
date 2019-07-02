package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public int size() {
        return this.players.size();
    }

    public List<String> getPlayersNames() {
        return players.stream()
                .map(player -> player.getName())
                .collect(Collectors.toList());
    }

    public int getMaxNameLength() {
        int max = Integer.MIN_VALUE;
        for (Player player : players) {
            max = player.max(max);
        }

        return max;
    }
}
