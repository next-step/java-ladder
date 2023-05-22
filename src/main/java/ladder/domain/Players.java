package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private List<Player> players;

    public Players(List<String> names) {
        players = names.stream()
                .map(name -> new Player(name))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int size() {
        return players.size();
    }
}
