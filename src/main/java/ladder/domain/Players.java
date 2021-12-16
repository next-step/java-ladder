package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Players {

    private static final String SPACE = " ";
    private static final String EMPTY = "";
    private static final String DELIMITER = ",";
    private final List<Player> players;

    public Players(String text) {
        players = new ArrayList<>();
        init(text);
    }

    private void init(String text) {
        List<String> person = Arrays.asList(text.replaceAll(SPACE, EMPTY).split(DELIMITER));
        person.forEach(player -> players.add(new Player(player)));
    }

    public int getCount() {
        return players.size();
    }
}
