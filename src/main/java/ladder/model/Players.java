package ladder.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private List<Player> players;

    private Players(List<Player> players) {
        this.players = Collections.unmodifiableList(players);
    }

    public static Players create(List<Player> players) {
        return new Players(players);
    }

    public int getPlayerCount() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player findPlayer(String name){
        return players.stream()
                .filter(it -> name.equals(it.getName()))
                .findFirst().orElseThrow(RuntimeException::new);
    }
}
