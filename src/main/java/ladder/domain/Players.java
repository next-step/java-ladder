package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private static final String SPACE = " ";
    private static final String EMPTY = "";
    private static final String DELIMITER = ",";
    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = players;
    }

    public static Players of(String text) {
        List<Player> players = Arrays.stream(text.replaceAll(SPACE, EMPTY).split(DELIMITER))
                .map(Player::new)
                .collect(Collectors.toList());
        return new Players(players);
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public int count() {
        return players.size();
    }

    public int getPlayerIndex(Player player) {
        return this.players.indexOf(player);
    }
}
