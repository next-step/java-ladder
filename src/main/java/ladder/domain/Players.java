package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Players {
    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = players;
    }

    public static Players register(String players) {
        return new Players(Arrays.stream(players.split(","))
                .map(player -> new Player(player.trim()))
                .collect(Collectors.toList()));
    }

    public int size() {
        return players.size();
    }

    public int lengthOfLongestName() {
        return players.stream()
                .map(player -> player.lengthOfName())
                .max(Integer::compareTo).get();
    }
    
    public Point_old pointOfPlayer(Player player) {
    	return new Point_old(players.indexOf(player));
    }
    
    public Position getPosition(Player player) {
    	return new Position(players.indexOf(player));
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
    public Stream<Player> getStream() {
        return players.stream();
    }
}
