package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private static final String SEPARATOR = ",";

    private final List<Player> players = new ArrayList<>();

    public Players(String names) {
        String[] splitNames = names.split(SEPARATOR);
        for (int i = 0; i < splitNames.length; i++) {
            players.add(new Player(splitNames[i], i));
        }
    }

    public int playerCount() {
        return players.size();
    }



}
