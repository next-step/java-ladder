package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Players {

    private static final String SPACE = " ";
    private static final String EMPTY = "";
    private static final String DELIMITER = ",";
    private final List<Player> players;

    private Players(String text) {
        players = new ArrayList<>();
        init(text);
    }

    public static Players of(String text) {
        return new Players(text);
    }

    private void init(String text) {
        List<String> person = Arrays.asList(text.replaceAll(SPACE, EMPTY).split(DELIMITER));
        person.forEach(player -> players.add(new Player(player)));
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public int count() {
        return players.size();
    }
}
