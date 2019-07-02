package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private List<Player> players;

    public Players(String players) {
        this.players = register(players);
    }

    private List<Player> register(String players) {
        return Arrays.stream(players.split(","))
                .map(player -> new Player(player.trim()))
                .collect(Collectors.toList());
    }

    public int size() {
        return players.size();
    }

    public int lengthOfLongestName() {
        return players.stream()
                .map(player -> player.lengthOfName())
                .max(Integer::compareTo).get();
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

}
